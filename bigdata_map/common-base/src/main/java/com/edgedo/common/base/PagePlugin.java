package com.edgedo.common.base;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import javax.xml.bind.PropertyException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

@Intercepts({    @Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class,Integer.class}
)})
public class PagePlugin implements Interceptor {
	private static String dialect = "";
    private static String pageSqlId = "";

    public PagePlugin() {
    }

    public Object intercept(Invocation ivk) throws Throwable {
    	
    	
    	Object temobj = ivk.getTarget();
    	RoutingStatementHandler statementHandler = null;
    	if(temobj instanceof RoutingStatementHandler){
    		statementHandler = (RoutingStatementHandler)temobj;
    	}else{
    		
        	Object obj1 = ReflectHelper.getValueByFieldName(temobj, "h");
        	if(obj1!=null){
        		Object targetObj = ReflectHelper.getValueByFieldName(obj1, "target");
        		if(targetObj instanceof RoutingStatementHandler){
            		statementHandler = (RoutingStatementHandler)targetObj;
            	}
        	}
    	}
    	
        if(statementHandler != null) {
            BaseStatementHandler delegate = (BaseStatementHandler)ReflectHelper.getValueByFieldName(statementHandler, "delegate");
            MappedStatement mappedStatement = (MappedStatement)ReflectHelper.getValueByFieldName(delegate, "mappedStatement");
            if(mappedStatement.getId().matches(pageSqlId)) {
                BoundSql boundSql = delegate.getBoundSql();
                Object parameterObject = boundSql.getParameterObject();
                if(parameterObject == null) {
                    throw new NullPointerException("parameterObject尚未实例化！");
                }

                Connection connection = (Connection)ivk.getArgs()[0];
                String sql = boundSql.getSql();
                String countSql = "";
                //解析mybatis注解部分的内容
                String[] arr = sql.split("\\*\\/");
                if(arr.length>1){
                    String myCatZhujie = arr[0] + "*/";
                    String sqlReal =  arr[1];
                    String sqlLower = sqlReal.toLowerCase();
                    int fromIndex = sqlLower.indexOf(" from ");
                    countSql = "select count(1) " + sqlLower.substring(fromIndex);
                    int orderIndex = countSql.lastIndexOf(" order ");
                    if(orderIndex>=0){
                        int kuohaoIndex = countSql.lastIndexOf(")");
                        if(kuohaoIndex<orderIndex){
                            countSql = countSql.substring(0,orderIndex) ;
                        }
                    }
                    countSql = myCatZhujie + countSql;
                }else{
                    String sqlLower = sql.toLowerCase();
                    int fromIndex = sqlLower.indexOf(" from ");
                    countSql = "select count(1) " + sqlLower.substring(fromIndex);
                    int orderIndex = countSql.lastIndexOf(" order ");
                    if(orderIndex>=0){
                        int kuohaoIndex = countSql.lastIndexOf(")");
                        if(kuohaoIndex<orderIndex){
                            countSql = countSql.substring(0,orderIndex) ;
                        }
                    }
                }

//                String countSql = "select count(0) from (" + sql + ") tmp_count";
                PreparedStatement countStmt = connection.prepareStatement(countSql);
                BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql, boundSql.getParameterMappings(), parameterObject);
                this.setParameters(countStmt, mappedStatement, countBS, parameterObject);
                ResultSet rs = countStmt.executeQuery();
                int count = 0;
                if(rs.next()) {
                    count = rs.getInt(1);
                }

                rs.close();
                countStmt.close();
                QueryObj page = null;
                if(parameterObject instanceof QueryObj) {
                    page = (QueryObj)parameterObject;
                    page.setTotalCount(count);
                } else {
                    Field pageSql = ReflectHelper.getFieldByFieldName(parameterObject, "page");
                    if(pageSql == null) {
                        throw new NoSuchFieldException(parameterObject.getClass().getName() + "不存在 page 属性！");
                    }

                    page = (QueryObj)ReflectHelper.getValueByFieldName(parameterObject, "page");
                    if(page == null) {
                        page = new QueryObj();
                    }

                    page.setTotalCount(count);
                    ReflectHelper.setValueByFieldName(parameterObject, "page", page);
                }

                String pageSql1 = this.generatePageSql(sql, page);
                ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql1);
            }
        }

        return ivk.proceed();
    }

    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql, Object parameterObject) throws SQLException {
        ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
        List parameterMappings = boundSql.getParameterMappings();
        if(parameterMappings != null) {
            Configuration configuration = mappedStatement.getConfiguration();
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            MetaObject metaObject = parameterObject == null?null:configuration.newMetaObject(parameterObject);

            for(int i = 0; i < parameterMappings.size(); ++i) {
                ParameterMapping parameterMapping = (ParameterMapping)parameterMappings.get(i);
                if(parameterMapping.getMode() != ParameterMode.OUT) {
                    String propertyName = parameterMapping.getProperty();
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                    Object value;
                    if(parameterObject == null) {
                        value = null;
                    } else if(typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                        value = parameterObject;
                    } else if(boundSql.hasAdditionalParameter(propertyName)) {
                        value = boundSql.getAdditionalParameter(propertyName);
                    } else if(propertyName.startsWith("__frch_") && boundSql.hasAdditionalParameter(prop.getName())) {
                        value = boundSql.getAdditionalParameter(prop.getName());
                        if(value != null) {
                            value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));
                        }
                    } else {
                        value = metaObject == null?null:metaObject.getValue(propertyName);
                    }

                    TypeHandler typeHandler = parameterMapping.getTypeHandler();
                    if(typeHandler == null) {
                        throw new ExecutorException("There was no TypeHandler found for parameter " + propertyName + " of statement " + mappedStatement.getId());
                    }

                    typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
                }
            }
        }

    }

    private String generatePageSql(String sql, QueryObj page) {
        if(page != null && notEmpty(dialect)) {
            StringBuffer pageSql = new StringBuffer();
            if(page.getOrderBy()!= null && !page.getOrderBy().equals("")) {
                sql = sql + " order by " + page.getOrderBy();
            }
            Integer start = page.getStart();
            Integer limit = page.getLimit();
            if(start != null && limit!=null){
	            if("mysql".equals(dialect)) {
	                pageSql.append(sql);
	                pageSql.append(" limit " + page.getStart() + "," + page.getLimit());
	               
	            } else if("oracle".equals(dialect)) {
	                pageSql.append("select * from (select tmp_tb.*,ROWNUM row_id from (");
	                pageSql.append(sql);
	                pageSql.append(") tmp_tb where ROWNUM<=");
	                pageSql.append(page.getStart() + (long)page.getTotalPage());
	                pageSql.append(") where row_id>");
	                pageSql.append(page.getStart());
	            }
            	return pageSql.toString();
        	}else{
        		return sql;
        	}
        } else {
            return sql;
        }
    }

    public Object plugin(Object arg0) {
        return Plugin.wrap(arg0, this);
    }

    public void setProperties(Properties p) {
        dialect = p.getProperty("dialect");
        if(isEmpty(dialect)) {
            try {
                throw new PropertyException("dialect property is not found!");
            } catch (PropertyException var4) {
                var4.printStackTrace();
            }
        }

        pageSqlId = p.getProperty("pageSqlId");
        if(isEmpty(pageSqlId)) {
            try {
                throw new PropertyException("pageSqlId property is not found!");
            } catch (PropertyException var3) {
                var3.printStackTrace();
            }
        }

    }
    
    
    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    public static boolean notEmpty(String str) {
        return !isEmpty(str);
    }

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	public String getPageSqlId() {
		return pageSqlId;
	}

	public  void setPageSqlId(String pageSqlId) {
		this.pageSqlId = pageSqlId;
	}


    
}

package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataAlarmRecord;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataAlarmRecordMapper  extends BaseMapper<BigdataAlarmRecord>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataAlarmRecordView> listPage(BigdataAlarmRecordQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataAlarmRecordView> listByObj(BigdataAlarmRecordQuery query);


	int alsrmCount(BigdataAlarmRecordQuery query);

	public List<BigdataAlarmRecordView> selectByQueryInfo(BigdataAlarmRecordQuery query);

	List selectCarList(BigdataAlarmRecordQuery query);

	int countCarList(BigdataAlarmRecordQuery query);

	List selectseriousCarList(BigdataAlarmRecordQuery query);

	int countseriousCarList(BigdataAlarmRecordQuery query);

	List selectAlarmRecordByCar(BigdataAlarmRecordQuery query);

    List<BigdataAlarmRecordView> getOverSpeedPoint(BigdataAlarmRecordQuery query);

	List<BigdataAlarmRecordView> getPilaoPoint(BigdataAlarmRecordQuery query);

	List<BigdataAlarmRecordView> getSeriousPilaoPoint(BigdataAlarmRecordQuery query);
}
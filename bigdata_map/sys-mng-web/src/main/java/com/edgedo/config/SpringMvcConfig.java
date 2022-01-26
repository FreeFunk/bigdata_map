package com.edgedo.config;

import com.edgedo.common.base.json.BaseObjectMapper;
import com.edgedo.common.base.json.MappingJackson2JsonView;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer{

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //开启路径后缀匹配
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }


    /**
     * 配置静态资源访问的路径规则以及查找静态资源的路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 处理所有HTML的请求，到static目录下查找对应的资源
         */
        registry.addResourceHandler(
                "/index.html","/login.html","/views/**.html","/layuiadmin/**.html","/**.css","/**.js","/**.png","/**.gif","/**.ico","/**.jpeg"
                ,"/**.jpg","/**.json","/**.txt","/**.htm"
        ).addResourceLocations("classpath:/static/","classpath:/public/");
    }

    /**
     * 进行跨域访问相关配置
     * @param registry
     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/test1/**") //可以跨域访问的URL路规则
//                .allowedOrigins("http://localhost:8080/")  //可以跨域访问的访问者
//                .allowedMethods("GET", "POST", "PUT", "DELETE") //可以跨域访问的方法
//                .allowedHeaders("");     //可以跨域访问的Headers
//    }





    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver(){
        ContentNegotiatingViewResolver resolver=new ContentNegotiatingViewResolver();
        resolver.setOrder(0);
        resolver.setContentNegotiationManager(contentNegotiationManagerFactoryBean().getObject());
        ArrayList<View> viewList = new ArrayList<View>();
        MappingJackson2JsonView jackson2JsonView = new MappingJackson2JsonView();
        BaseObjectMapper bom = new BaseObjectMapper();
        bom.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        jackson2JsonView.setObjectMapper(bom);
        viewList.add(jackson2JsonView);
        resolver.setDefaultViews(viewList);
        return resolver;
    }

    @Bean
    public ContentNegotiationManagerFactoryBean contentNegotiationManagerFactoryBean(){
        ContentNegotiationManagerFactoryBean bean=new ContentNegotiationManagerFactoryBean();
        bean.setIgnoreAcceptHeader(true);
        bean.setFavorPathExtension(true);
        bean.setFavorParameter(false);
        bean.setDefaultContentType(MediaType.TEXT_HTML);
        Map<String,MediaType> map=new HashMap<>();
        map.put("html",MediaType.TEXT_HTML);
        map.put("jsn",MediaType.APPLICATION_JSON);
        bean.addMediaTypes(map);
        return bean;
    }

    @Bean
    public BeanNameViewResolver beanNameViewResolver(){
        BeanNameViewResolver resolver=new BeanNameViewResolver();
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public InternalResourceViewResolver defaultViewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setOrder(2);
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setContentType("text/html");
        viewResolver.setPrefix("/template/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


}

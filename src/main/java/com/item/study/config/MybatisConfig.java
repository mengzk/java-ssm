package com.item.study.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: MyBatis相关配置
 */

@Configuration
@EnableTransactionManagement
@MapperScan({"com.item.study.mapper"})
//@MapperScan({"com.item.study.mapper", "com.item.study.model.mapper"})
public class MybatisConfig {

//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
//
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//        configuration.getTypeHandlerRegistry().register(Date.class, new DateHandler());
//        sessionFactory.setConfiguration(configuration);
//
//        return sessionFactory.getObject();
//    }
}

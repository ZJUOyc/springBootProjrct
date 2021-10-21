package com.oyc.redpacketgame.dbconfig;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.oyc.redpacketgame.dao", sqlSessionTemplateRef = "mainSqlSessionTemplate")
public class mainDbConfig extends BaseDbConfig {
    @Bean(name = "mainDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mainSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("mainDataSource")DataSource DataSource) throws Exception{
        return getSqlSessionFactory(DataSource,"classpath:mapper/*.xml");
    }

    @Bean(name = "mainTransactionManager")
    public DataSourceTransactionManager testTransactionManager (@Qualifier("mainDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean (name = "mainSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate (@Qualifier("mainSqlSessionFactory")SqlSessionFactory SqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(SqlSessionFactory);
    }
}

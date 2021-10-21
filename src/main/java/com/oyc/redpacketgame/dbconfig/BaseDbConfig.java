package com.oyc.redpacketgame.dbconfig;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

public abstract class BaseDbConfig {
    SqlSessionFactory getSqlSessionFactory (DataSource dataSource, String mapperPattern) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(getResource(mapperPattern));
        bean.setConfiguration(getConfiguration());
        return bean.getObject();
    }

    private Resource[] getResource(String mapperPattern) throws IOException {
        return new PathMatchingResourcePatternResolver().getResources(mapperPattern);
    }

    private Configuration getConfiguration () {
        Configuration configuration = new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        return configuration;
    }
}

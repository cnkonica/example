package com.cnkonica.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.cnkonica.example.dao.secondary.mybatis.mapper",sqlSessionFactoryRef = "secondarySqlsessionFactory")
public class SecondaryMybatisConfig {
    @Bean(name = "secondaryTransactionmanager")
    public DataSourceTransactionManager secondaryTransactionmanager(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "secondarySqlsessionFactory")
    public SqlSessionFactory secondarySqlsessionFactory(@Qualifier("secondaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mappers/secondary/**/*.xml"));
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        config.setLazyLoadingEnabled(true);
        config.setDefaultStatementTimeout(300);
        sessionFactory.setConfiguration(config);
        return sessionFactory.getObject();
    }

}

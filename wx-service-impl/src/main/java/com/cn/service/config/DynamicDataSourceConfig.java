package com.cn.service.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfig {

    @Value("${datasource-master.filters}")
    private String masterFilters;

    @Value("${datasource-slave.filter-connectProperties}")
    private String masterConnectionProperties;

    @Value("${datasource-slave.filters}")
    private String slaveFilters;

    @Value("${datasource-slave.filter-connectProperties}")
    private String slaveConnectionProperties;

    @Bean(name = {"masterSource"})
    @ConfigurationProperties(prefix = "datasource-master")
    public DataSource masterDataSource() throws SQLException {
        DruidDataSource build = DruidDataSourceBuilder.create().build();
        build.setFilters(masterFilters);
        build.setConnectionProperties(masterConnectionProperties);
        return build;
    }

    @Bean(name = {"slaveSource"})
    @ConfigurationProperties(prefix = "datasource-slave")
    public DataSource slaveDataSource() throws SQLException {
        DruidDataSource build = DruidDataSourceBuilder.create().build();
        build.setFilters(slaveFilters);
        build.setConnectionProperties(slaveConnectionProperties);
        return build;
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("masterSource") DataSource masterDataSource, @Qualifier("slaveSource") DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(4);
        targetDataSources.put("master", masterDataSource);
        targetDataSources.put("slave", slaveDataSource);
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }
}

package com.onehappystone.commons.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by happy on 2017/7/3.
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix="jdbc.master")
    public DruidDataSource primaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix="jdbc.slave")
    public DruidDataSource secondaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dynamicDataSource(@Qualifier("primaryDataSource") DataSource masterDataSource,
                                               @Qualifier("secondaryDataSource") DataSource slaveDataSource){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> datasourceMap = new HashMap<>();
        datasourceMap.put("read_writeDataSource", masterDataSource);
        datasourceMap.put("readDataSource", slaveDataSource);
        dynamicDataSource.setTargetDataSources(datasourceMap);
        return dynamicDataSource;
    }
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dynamicDataSource){
        return new DataSourceTransactionManager(dynamicDataSource);
    }
}

package com.water.example.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.water.example")
public class RootConfiguration {

    @Bean
    public DataSource dataSource() throws IOException {
        DruidDataSource dataSource = new DruidDataSource();
        Properties properties =  new Properties();
        properties.load(this.getClass().getResourceAsStream("/db.properties"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
        dataSource.setUrl(properties.getProperty("jdbc.password"));
        dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(8);
        return  dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        Resource  resource = new ClassPathResource("mybatis/SqlMapConfig.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.water.example.mapper");
        return configurer;
    }

}

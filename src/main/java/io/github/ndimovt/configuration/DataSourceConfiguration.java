package io.github.ndimovt.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * The class DataSourceConfiguration
 */
@Configuration
public class DataSourceConfiguration {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String pass;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    /**
     * Returns DriverManagerDataSource instance with the given parameters
     * @return DriverManagerDataSource object
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(driverClassName);
        source.setUrl(url);
        source.setUsername(username);
        source.setPassword(pass);
        return source;
    }

}

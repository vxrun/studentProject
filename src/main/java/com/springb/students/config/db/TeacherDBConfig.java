package com.springb.students.config.db;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "teacherEntityManagerFactory", transactionManagerRef = "teacherTransactionManager", basePackages = {
		"com.springb.teacher.DAO" })
public class TeacherDBConfig {

	// configuring data source
	@Bean(name = "teacherProperties")
	@ConfigurationProperties("spring.teachers.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "teacherDatasource")
	@ConfigurationProperties(prefix = "spring.teachers.datasource")
	public DataSource datasource(@Qualifier("teacherProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}
	
	//configuring entity manager
	@Bean(name = "teacherEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("teacherDatasource") DataSource dataSource) {
		Map<String, String> map=new HashMap<>();
		map.put("hibernate.ddl-auto", "create");
		//		properties.setProperty("hibernate.ddl-auto", "create");
		return builder.dataSource(dataSource).properties(map).packages("com.springb.students.entity")
				.build();
	}
	
	//configuring transactional manager
	@Bean(name = "teacherTransactionManager")
	@ConfigurationProperties("spring.jpa")
	public PlatformTransactionManager transactionManager(
	        @Qualifier("teacherEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

	    return new JpaTransactionManager(entityManagerFactory);
	}
}

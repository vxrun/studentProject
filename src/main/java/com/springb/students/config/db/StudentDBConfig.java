package com.springb.students.config.db;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "studentEntityManagerFactory", transactionManagerRef = "studentTransactionManager", basePackages = {
		"com.springb.students.DAO" })
public class StudentDBConfig {

	@Primary
	@Bean(name = "studentProperties")
	@ConfigurationProperties("spring.students.datasource")
	public DataSourceProperties studentDataSource() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean(name = "studentDatasource")
	@ConfigurationProperties(prefix = "spring.students.datasource")
	public DataSource datasource(@Qualifier("studentProperties") DataSourceProperties properties) {

		return properties.initializeDataSourceBuilder().build();
	}

	// configuring entity manager
	@Primary
	@Bean(name = "studentEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("studentDatasource") DataSource dataSource) {

		return builder.dataSource(dataSource).packages("com.springb.students.entity")
				.build();
	}

	// configuring transactional manager
	@Primary
	@Bean(name = "studentTransactionManager")
	@ConfigurationProperties("spring.jpa")
	public PlatformTransactionManager transactionManager(
			@Qualifier("studentEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

		return new JpaTransactionManager(entityManagerFactory);
	}
}

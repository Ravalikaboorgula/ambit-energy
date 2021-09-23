package com.ambit.project.ambit_energy;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("accountDetailsDao")
@EntityScan("com.ambit.pojos")
@EnableJpaRepositories("accountDetailsDao")
public class AmbitEnergyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmbitEnergyApplication.class, args);
	}
	
	@Bean
	public DataSource getDataSource(){
		return DataSourceBuilder.create()
				.url("jdbc:oracle:thin:@localhost:1521/orcl")
				.username("hr")
				.password("oracle")
				.build();
		
	}

}

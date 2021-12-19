package com.ambit.project.ambit_energy;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ambit.project.ambit_energy.pojos")
@EnableJpaRepositories("com.ambit.project.ambit_energy.accountDetailsDao")
public class AmbitEnergyApplication {


	public static void main(String[] args) {
//		if(args[0].equals("qa")){
//			System.out.println("You are in "+args[0]+" environment");
//		}
//		else if(args[0].equals("prod")){
//			System.out.println("You are in "+args[0]+" environment");
//		}
//		else{
//			System.out.println("You are in "+args[0]+" environment");
//		}
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

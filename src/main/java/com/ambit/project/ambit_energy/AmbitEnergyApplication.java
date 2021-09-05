package com.ambit.project.ambit_energy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("accountDetailsDao")
public class AmbitEnergyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmbitEnergyApplication.class, args);
	}

}

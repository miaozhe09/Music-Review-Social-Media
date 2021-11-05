package com.glasgow.wind;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.glasgow.wind.dao")
@SpringBootApplication
public class WindApplication {

	public static void main(String[] args) {
		SpringApplication.run(WindApplication.class, args);
	}

}

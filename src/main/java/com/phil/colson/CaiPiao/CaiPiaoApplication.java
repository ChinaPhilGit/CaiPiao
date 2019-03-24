package com.phil.colson.CaiPiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CaiPiaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaiPiaoApplication.class, args);
	}

}

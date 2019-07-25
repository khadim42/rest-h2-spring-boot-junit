package com.kh.embl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Myapplication {

	public static void main(String[] args) {
		System.out.println("This is master branch");
		System.out.println("TST1-brnch commit");
		SpringApplication.run(Myapplication.class, args);
	}
}
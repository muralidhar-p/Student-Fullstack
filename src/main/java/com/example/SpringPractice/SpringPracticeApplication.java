package com.example.SpringPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.SpringPractice.Model.ChildClass;
import com.example.SpringPractice.Model.EmployeeDetail;

@SpringBootApplication
public class SpringPracticeApplication {

	
	public static void main(String[] args) {
//		System.setProperty("server.servlet.context-path", "/webpages");
		ConfigurableApplicationContext context = SpringApplication.run(SpringPracticeApplication.class, args);
		
	
//		EmployeeDetail empD = context.getBean(EmployeeDetail.class);
		
		context.getBean(ChildClass.class);
//		emp.inShow();
		
		
	}

}

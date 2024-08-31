package com.example.SpringPractice.Model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("prototype")
public class ChildClass {
	

	public ChildClass() {
		System.out.println("Child Class Constructer");
		
	}
	

}

package com.example.SpringPractice.Model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class EmployeeDetail {
	
	
	int id ; 
	String EmpName;
	
//	@Qualifier("Work1")
//	Employee emp ;

	public EmployeeDetail() {
		super();
		System.out.println("Employee Detail");
	} 
	
	

}

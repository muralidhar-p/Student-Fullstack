package com.example.SpringPractice.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

//import javax.persistence.Entity;
//import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component("Work1")
//@Entity
@Scope("prototype")
@Primary
public class Worker extends NaukarClass {
	
	@Id
	int Eid;
	String Name;
	String Department;
	int Salary;
	NaukarClass naukar;
	
	public Worker() {
		super();
		System.out.println("Constructor Called Worker" + this.naukar);
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [Eid=" + Eid + ", Name=" + Name + ", Department=" + Department + ", Salary=" + Salary + "]";
	}
	
	public void inShow()
	{
		System.out.println("Hello Birather");
	}
	
	

}

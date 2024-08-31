package com.example.SpringPractice.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringPractice.DAO.StudentDao;
import com.example.SpringPractice.Model.Student;




@RestController
@RequestMapping("student")
public class StudentApi {

	
	@Autowired
	StudentDao dao;
	
	@Autowired
	Student student;
	
	
	
	@PostMapping(path = "add", consumes = "application/json" ,produces = "application/json")
	Student AddStudent(@RequestBody Student data) {
		
		return dao.save(data);
	}
	
	@GetMapping(path = "getname" ,produces = "application/json")
	ArrayList<Student> getPeople(String fname) {
		
		return dao.findByFname(fname);
	}
	
	
	@GetMapping(path = "getbyid/{id}" ,produces = "application/json")
	Optional<Student> getById(@PathVariable int id) {
		
		return dao.findById(id);
	}
	
	@PutMapping(path = "updstd", consumes = "application/json" ,produces = "application/json")
	Student getById(@RequestBody Student data) {
		
		return dao.save(data);
	}
	
	
	@DeleteMapping(path = "deletebyid/{id}",produces = "application/json")
	boolean deleteById(@PathVariable int  id) {
		
		
		dao.deleteById(id);
		
		Optional<Student> s = dao.findById(id);
		
		return ( s ==null ) ?  false : true ;
		
		 
	}
	
	
	
	
	
}

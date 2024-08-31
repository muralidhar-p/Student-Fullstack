package com.example.SpringPractice.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringPractice.DAO.StudentDao;
import com.example.SpringPractice.Model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller()
@RequestMapping("form")
public class FormController {
	
	@Autowired
	Student student;
	
	@Autowired
	StudentDao stdDao;
	
	@GetMapping("addstudent")
	ModelAndView OpenStudentForm() {
		System.out.println("url");
		
		ModelAndView model = new ModelAndView();
		
		model.setViewName("AddStudent");
		
		return model ; 
	}
	
	
	
	
	
	@PostMapping(path = "addstudent", produces="application/json")
	ModelAndView AddStudent(String fname , String lname ) {
		
		ModelAndView model = new ModelAndView();
		
		student.setFname(fname);
		student.setLname(lname);
		stdDao.save(student);
		
		model.addObject("msg" , "Achcha tata BYe Bye");
		model.setViewName("AddStudent");
		
		ArrayList<Student> data = stdDao.findByFname(fname);
		data.forEach(i -> System.out.println(i.getFname() + " " + i.getLname() ));	
		
		String d = ListToJson(data);
		
	      System.out.println(d);
//	      model.addObject(lname, objectMapper)
		model.addObject("data" , d);
		
		return model ; 
	}

	
	
	static String ListToJson(ArrayList<Student> list) {
		
	String json = ""  ;
		
		ObjectMapper objectMapper = new ObjectMapper();
	      try {
	         json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
	         System.out.println(json);
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      return json ;
	}
	
	
	
	
}

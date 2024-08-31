package com.example.SpringPractice.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import com.example.demo.modal.Employee;

@Controller

public class WebAppController {

	// Web API
	@GetMapping("webpage")
	@ResponseBody
	String MyFirstPage() {
		System.out.println("Called");
		return "I luv My pAge";
	}
	
	//Web PAge
	@GetMapping("webpages")
	String MyFirstWebPage() {
		System.out.println("Called");
		int id = 9;
		return "webpage.jsp";
	}
	
	// Web API using path vairable
		@GetMapping("webpage/{id}")
		@ResponseBody
		String MyWebFirstPage(@PathVariable Object  id) {
			
			System.out.println("Called");
			return "I luv My pAge " + id;
		}
	
		
		// Web page using Servlet
		@GetMapping("mymvcpage/{id}")
		String MyWebFirstPage(HttpServletRequest req , @PathVariable int id) {
			
			System.out.println(req.getParameter("name"));
			System.out.println(req.getParameter("class"));
			System.out.println(id);
			HttpSession session = req.getSession();
			
			req.setAttribute("MyName", req.getParameter("name"));
			req.setAttribute("Myclass", req.getParameter("class"));
			System.out.println(session.getId());
			return "webpage";
		}
		// My First jsp MVC page 
		@GetMapping("mvcpage/{id}")
		ModelAndView MyWebFirstMVCPage(  String classname ,@RequestParam("name") String roll , @PathVariable int id) {
			
			System.out.println(roll);
			ModelAndView model = new ModelAndView();
			model.setViewName("webpage");
			model.addObject("name" , roll);
			model.addObject("className" , classname);
			
			System.out.println(id);
		
			
			return model;
		}
		
//		@GetMapping("mvcpageemp")
//		ModelAndView MyWebFirstMvcTypePage(Employee emp) {
//			
//			
//			ModelAndView model = new ModelAndView();
//			model.setViewName("webpage");
//			System.out.println(emp);
//			model.addObject("emp" , emp);
//			
//		
//			
//			return model;
//		}
}

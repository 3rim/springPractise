package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	//need a controller method to show initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	/**
	 *  new controller to read form data and add data to the model
	 */
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(HttpServletRequest request, Model model) {
		//read the request parameter from the HTML form
		String name = request.getParameter("studentName");
		
		//convert the date to all caps
		name = name.toUpperCase();
		
		//create the message
		String message = "YO! " + name;
		
		//add message to the model
		model.addAttribute("message",message);
		
		return "helloworld";
	}
	
	/**
	 *  new controller to read form data and add data to the model
	 *  The @RequestParam is a Spring feature which will read the param from
	 *  request: studentName and bind it to the variable: name
	 */
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName")String name, Model model) {
		
		//With  *@RequestParam("studentName")String name*  the below code is unnecessary. Spring does it for you
		//String name = request.getParameter("studentName");
		
		//convert the date to all caps
		name = name.toUpperCase();
		
		//create the message
		String message = "YO! " + name;
		
		//add message to the model
		model.addAttribute("message",message);
		
		return "helloworld";
	}

}







package com.masumpranto.main.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.masumpranto.main.model.Programmer;
import com.masumpranto.main.repository.ProgrammerRepo;

@Controller
@ControllerAdvice
public class MainController {
	
	@Autowired
	ProgrammerRepo pr;
	
	@ModelAttribute
	public void welcome(Model m) {
		m.addAttribute("msg", "Welcome to CRUD App");
	}
	
	@GetMapping
	public String homePage() {
		return "HomePage.html";
	}
	
	@PostMapping("/allProgrammer")
	public String addProgrammer(@ModelAttribute Programmer programmer) {
		pr.save(programmer);
		return "redirect:/home";
	}
	
	@PostMapping("/findById")
	public String findById(@RequestParam int pId, Model m) {
		Programmer p = pr.getOne(pId);
		
		m.addAttribute("programmer", p);
		
		return "ProgrammerInfo.html";
	}
}

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HomeController {

	@RequestMapping("/home")
	@ResponseBody
	public String showMain()
	{
		return "main.3r3.";
	}
}

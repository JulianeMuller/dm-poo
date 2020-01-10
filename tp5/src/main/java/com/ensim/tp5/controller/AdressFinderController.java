package com.ensim.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdressFinderController {
	
	@GetMapping ("/adressesFinder")
	public String showAddresses ( Model model ) 
	{
		return "adressesFinder";
	}

}

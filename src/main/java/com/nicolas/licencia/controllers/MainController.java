package com.nicolas.licencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nicolas.licencia.models.License;
import com.nicolas.licencia.models.Person;
import com.nicolas.licencia.services.MainService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private MainService serv;

	//RUTAS PERSONA
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("todos",serv.showAll());
		return "index.jsp";
	}
	
	@GetMapping("/{id}")
	public String mostrarCancion(Model m, @PathVariable("id") Long id) {
		m.addAttribute("show",serv.showPersonById(id));
		return "show.jsp";
	}
	
	@GetMapping("/persons/new")
	public String formPersona(@ModelAttribute("persona") Person persona) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/persons/new")
	public String nuevaPersona(@Valid @ModelAttribute("persona") Person persona, BindingResult binding) {
		if (binding.hasErrors()) {
			return "newPerson.jsp";
		} else {
			serv.createPerson(persona);
			return "redirect:/";
		}
	}
	
	//RUTAS LICENCIA
	@GetMapping("/license/new")
	public String formLicencia(@ModelAttribute("licencia") License licencia,Model m) {
		List<Person> per = serv.findByNoLicense();
		m.addAttribute("per",per);
		return "newLicense.jsp";
	}
	
	@PostMapping("/license/new")
	public String nuevaLicencia(@Valid @ModelAttribute("licencia") License licencia, BindingResult binding) {
		if (binding.hasErrors()) {
			return "newLicense.jsp";
		} else {
			serv.createLicense(licencia);
			return "redirect:/";
		}
	}
	
	
	
}

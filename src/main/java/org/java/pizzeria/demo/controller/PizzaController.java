package org.java.pizzeria.demo.controller;

import java.util.List;
import java.util.Optional;

import org.java.pizzeria.demo.pojo.Pizza;
import org.java.pizzeria.demo.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PizzaController {
	
	@Autowired
	private PizzaRepo pizzarepo;
	
	@GetMapping("/")
	public String getPizze(Model model) {
		List<Pizza> pizze = pizzarepo.findAll();
		model.addAttribute("pizze", pizze);
		return "index";
	}
	@PostMapping("/")
	public String goToPizzaIndexResearch(Model model, @RequestParam(required = false) String name) {

		List<Pizza> pizze = pizzarepo.findByNameContaining(name);

		model.addAttribute("pizze", pizze);
		model.addAttribute("searchTerm", name);

		return "index";
	}
	
	
	@GetMapping("/pizza/{id}")
	public String show(@PathVariable("id") int id, Model model ) {
		
		Optional <Pizza> optPizza = pizzarepo.findById(id);
		
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza",pizza);
		
		return "show";
	}
	
	@GetMapping("/pizza/create")
	public String create() {
		return "create";
	}
	@PostMapping("pizza/create")
	public String storeBook(@ModelAttribute Pizza pizza) {

		pizzarepo.save(pizza);

		return "redirect:/";
	}
}

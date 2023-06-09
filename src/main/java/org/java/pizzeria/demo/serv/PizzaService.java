package org.java.pizzeria.demo.serv;

import java.util.List;
import java.util.Optional;

import org.java.pizzeria.demo.pojo.Pizza;
import org.java.pizzeria.demo.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepo pizzarepo;
	
	public List<Pizza> findAll() {
		
		return pizzarepo.findAll();
	}
	public Pizza save(Pizza pizza) {
		
		return pizzarepo.save(pizza);
	}
	public Optional<Pizza> findById(int id) {
		
		return pizzarepo.findById(id);
	}
	
	public List<Pizza> findByNameContaining(String name){

		return pizzarepo.findByNameContaining(name);

	}
	
	public void deleteById(int id) {

		pizzarepo.deleteById(id);

	}

}

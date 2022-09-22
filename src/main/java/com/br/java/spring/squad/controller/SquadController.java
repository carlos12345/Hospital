package com.br.java.spring.squad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.java.spring.squad.model.Squad;
import com.br.java.spring.squad.repository.SquadRepository;

@Controller
public class SquadController {

	@Autowired
	private SquadRepository sr;
	@RequestMapping(value="/cadastrarSquad", method = RequestMethod.GET)
	public String form() {
		return "squad/formSquad";
	}
	
	@RequestMapping(value="/cadastrarSquad", method = RequestMethod.POST)
	public String form(Squad squad) {
		sr.save(squad);
		return "redirect:/cadastrarSquad";
	}
	@RequestMapping("/squads")
	public ModelAndView listaSquad() {
		ModelAndView mv = new ModelAndView("index.html");
		Iterable<Squad> squads = sr.findAll();
		mv.addObject("squads", squads);
		return mv;
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView detalhesSquad(@PathVariable("codigo") long codigo) {
		Squad squad = sr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("squad/detalhesSquad");
		mv.addObject("squad", squad);
		System.out.println("squad"+squad);
		return mv;
	}
}

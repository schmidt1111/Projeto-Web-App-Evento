package com.qintess.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.webapp.dao.Dao;
import com.qintess.webapp.model.CasaShow;

@Controller
@RequestMapping("/casashow")
public class CasaShowController {
	
	@Autowired
	private Dao dao;
	
	@RequestMapping("")
	public String carrega(Model model) {
		System.out.println("entrei no metodo carrega CasaShow!");
		
		//model.addAttribute("listacasashow", dao.buscaTodos(CasaShow.class));
		model.addAttribute("casashow", new CasaShow());
		return "casashow";
	}
	@RequestMapping("/salva")
	public String salva(@ModelAttribute CasaShow casashow) {
		//if(casashow.getId() == 0) {
			//dao.salva(casashow);
	//	} else {
		//	dao.altera(casashow);
		//}
		return "redirect:/casashow";
	}
	
}

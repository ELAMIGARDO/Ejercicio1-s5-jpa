package com.usmp.fia.sem5.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usmp.fia.sem5.models.dao.IClienteDao;
import com.usmp.fia.sem5.models.entity.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	@Qualifier("clienteDaoJpa")
	private IClienteDao clienteDao;
	
	@RequestMapping(value="/listar",method = RequestMethod.GET)
	public String lista(Model model) {
		
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}

	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		
		Cliente cliente=new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario del Cliente");
		
		return "form";
	}
	
	@RequestMapping(value="/form",method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result,Model model) {
		
		if (result.hasErrors()) {
			
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}
		
		clienteDao.save(cliente);		
		return "redirect:listar";		
	}
}

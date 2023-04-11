package com.crud1mintic.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.crud1mintic.app.entity.Agenda;
import com.crud1mintic.app.repository.IAgendaDao;



@Controller
@SessionAttributes("agenda")
public class AgendaController {
	
	@Autowired
	private IAgendaDao agendaDao;
	
	
	@RequestMapping(value="/listar",method = RequestMethod.GET)
	public String llamarListar(Model model)
	{
		model.addAttribute("agenda",agendaDao.findAll());
		return "listar";
	}
	
	
	
	@RequestMapping(value={"/form","/"},method = RequestMethod.GET)
	public String llamarformulario(Map<String,Object> model)
	{
		Agenda agenda = new Agenda();
		model.put("agenda", agenda);
		return "form";
	}
	
	
	
	@RequestMapping(value={"/form"},method = RequestMethod.POST)
	public String guardar(Agenda agenda)
	{
		agendaDao.save(agenda);
		return "redirect:listar";
	}

	
	
	@RequestMapping(value={"/eliminar/{id}"})
	public String eliminar (@PathVariable(value="id") Long id)
	{
		if (id > 0) {
			agendaDao.delete(id);
		}
		return "redirect:/listar";
	}
	
	
	@RequestMapping(value={"/form/{id}"})
	public String editar (@PathVariable(value="id") Long id, Map<String,Object> model)
	{
		Agenda agenda=null;
		if (id > 0) {
			agenda = agendaDao.findOne(id);
			
			} else {
				return "redirect:listar";
			}
		    model.put("agenda", agenda);
			return "form";
		}
		
}

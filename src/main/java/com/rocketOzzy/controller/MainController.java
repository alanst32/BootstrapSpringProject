package com.rocketOzzy.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rocketOzzy.model.ClientDB;
import com.rocketOzzy.service.ClientService;

@Controller
public class MainController {

	@Autowired
	ClientService clientService;	
	
	@RequestMapping(value="/html5Test")
	public ModelAndView html5Test(){
	
		return new ModelAndView("/html5/html5Test");
	}
	
	@RequestMapping(value="/bootstrapTest")
	public ModelAndView bootstrapTest(){
	
		return new ModelAndView("/bootstrapTest");
	}
	
	@RequestMapping(value="/bootstrapSpringGrid")
	public ModelAndView bootstrapSpringGrid(){
		
		return new ModelAndView("/bootstrapSpringGrid");
	}
	
	
	@RequestMapping(value="/getAllClients", method=RequestMethod.POST)
	@ResponseBody
	public List<ClientDB> getAllClients(HttpServletRequest req, HttpServletResponse resp){
		
		List<ClientDB> listClientDB = clientService.getAllClients();
		
		return listClientDB;
	}
	
	
	@RequestMapping(value="/insertClient", method=RequestMethod.POST)
	@ResponseBody
	public boolean insertClient(HttpServletRequest req, HttpServletResponse resp ) throws ParseException{
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		String name = req.getParameter("name") == null ? "": req.getParameter("name");
		String lastname = req.getParameter("lastname") == null ? "" : req.getParameter("lastname");
		String dateBirth = req.getParameter("dateBirth") == null ? "": req.getParameter("dateBirth");
		String register = req.getParameter("register") == null ? "": req.getParameter("register");
		
		ClientDB clientDB = new ClientDB();
		clientDB.setCliName(name);
		clientDB.setCliLastname(lastname);
		clientDB.setCliDatebirth(dateFormat.parse(dateBirth));
		clientDB.setCliRegister(register);
		
		boolean bok = clientService.insertClient(clientDB);
		
		return bok;
	}
	
	@RequestMapping(value="/deleteClient", method=RequestMethod.POST)
	@ResponseBody
	public boolean deleteClient( HttpServletRequest req, HttpServletResponse resp ) throws ParseException{
		
		String checked = req.getParameter("checked") == null ? "": req.getParameter("checked");
		
		ArrayList<BigDecimal> decArray = new ArrayList<BigDecimal>();
		
		for( String s : checked.split(",") ){
			decArray.add( new BigDecimal(s) );
		}
		
		boolean bok = clientService.deleteClientsByNumber(decArray);
		
		return bok;
	}
	
	
	
	
}

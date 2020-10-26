package com.delitheproject.iplteam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class PlayerController {
	
	@Autowired
	private PlayerService service;
	
	List<Player> temp;
	
	HttpSession session;
	
	@RequestMapping("/")
	public ModelAndView begin()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public ModelAndView let(@RequestParam("user") String user, @RequestParam("pass") String pass, HttpServletRequest request)
	{
		if(user.equalsIgnoreCase("team")&&pass.equalsIgnoreCase("team"))
		{
			session=request.getSession();     
			session.setAttribute("authorised", user);
			return new ModelAndView("home");
		}
		else {return new ModelAndView("index").addObject("msg", "Unauthorised login");}
	}
	
	@RequestMapping(value="/back")
	public ModelAndView again()
	{
		if(session.getAttribute("authorised")!=null)
		{return new ModelAndView("home"); }
		else {return new ModelAndView("index");}
	}
	
	
	@RequestMapping("/add")
	public ModelAndView askToAdd()
	{
		if(session.getAttribute("authorised")!=null)
		return new ModelAndView("import");
		else {return new ModelAndView("index");}
	}
	
	@RequestMapping(value="/newstock",method=RequestMethod.POST)
	public ModelAndView addSubmit(Player play, BindingResult bind)
	{
		if(session.getAttribute("authorised")!=null)
		{
			ModelAndView mod=new ModelAndView("import");
			if(bind.hasErrors()) {return mod;}   //?
			if(service.newadd(play)!=null)
			{
				mod.addObject("msg", "Player "+play.getPname()+" has added to the list");
			}
			else {mod.addObject("msg", "Player "+play.getPname()+" has not added to the list");}
			return mod;
		}
		else {return new ModelAndView("index");}
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView traverse()
	{
		if(session.getAttribute("authorised")!=null)
		{
		
			temp=service.every();
			return new ModelAndView("show").addObject("all", temp);
		}
		else {return new ModelAndView("index");}
		
	}
	
	@RequestMapping(value="/editable",method=RequestMethod.GET)
	public ModelAndView editRequest(@RequestParam("id") int id)
	{
		if(session.getAttribute("authorised")!=null)
		{
		
			Player p=service.single(id);
			return new ModelAndView("edit").addObject("one", p);
		}
		else {return new ModelAndView("index");}

		
	}
	
	@RequestMapping(value="/change",method=RequestMethod.POST)
	public ModelAndView editResponse(Player player)
	{
		if(session.getAttribute("authorised")!=null)
		{
		
			service.alter(player);
			return traverse().addObject("msg","Details of " +player.getPname()+" has updated");
		}
		else {return new ModelAndView("index");}
		
	}
	
	@RequestMapping(value="/deletable",method=RequestMethod.GET)
	public ModelAndView deleteRequest(@RequestParam("id") int id)
	{
		if(session.getAttribute("authorised")!=null)
		{
		
			Player temp=service.single(id);
			String hold=service.remove(temp);
			return traverse().addObject("msg","details of "+hold+" has deleted");
		}
		else {return new ModelAndView("index");}
		
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView out()
	{
		session.removeAttribute("authorised");
		session.setAttribute("authorised", null);
		return new ModelAndView("index").addObject("msg", "Logged out successfully");
	}

}

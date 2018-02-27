package ru.aoleynikov.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.aoleynikov.service.Service;
import ru.aoleynikov.model.AnonUser;


/**
 * Created by Anton on 29.06.2017.
 */
@Controller
public class UsersController {
    
	
	
	@GetMapping(value = "/users")
    public String start(ModelMap model) {
		System.out.println("0");
		model.addAttribute("ad", "ad"); // добавили аттрибут ad со значением ad 
    	return "RegView";
    }
	
	
	//@RequestParam(value="login", required = true) String login,
	@PostMapping(value = "/users")
    public String authUser(@RequestParam(value="login", required = true) String login, @RequestParam(value="password", required = true) String password, ModelMap model) {
		System.out.println("1");
		AnonUser anonUser = new AnonUser(login, password);
		Service service = new Service();
    	if (service.authUser(anonUser)) {
    		System.out.println("2");
    		return "UsersView";
    	} 
    	model.addAttribute("error", "wrong password");
    	return "RegView";
    }
	
	@PostMapping(value = "/asda")
	public String get() {
		return "UsersView";
	}
}

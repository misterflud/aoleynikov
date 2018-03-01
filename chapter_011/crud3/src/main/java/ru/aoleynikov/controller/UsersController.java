package ru.aoleynikov.controller;





import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import ru.aoleynikov.model.User;
import ru.aoleynikov.service.Service;
import ru.aoleynikov.model.AnonUser;


/**
 * Created by Anton on 29.06.2017.
 */
@Controller
public class UsersController {
	int b;
	
	static int i = 0;
	
	public UsersController() throws Exception {
		i++;
		b = i;
		System.out.println(i);
	}
	
	
	@GetMapping(value = "/start")
    public String regStart(ModelMap model) {
//		System.out.println(b);
		System.out.println("dddddddd");
		model.addAttribute("ad", "ad"); // добавили аттрибут ad со значением ad 
    	return "RegView";
    }
	
	
	//@RequestParam(value="login", required = true) String login,
	@PostMapping(value = "/start")
    public String regAuth(@RequestParam(value="login", required = true) String login, @RequestParam(value="password", required = true) String password, ModelMap model) {
		System.out.println("fffffffffff");
		AnonUser anonUser = new AnonUser(login, password);
		Service service = new Service();
    	if (service.authUser(anonUser)) {
//    		System.out.println("2");
    		return "redirect:users";
    	} 
    	model.addAttribute("error", "Wrong login or password");
    	return "RegView";
    }
	
	@GetMapping(value = "/users")
	public String usersStart() {
		return "UsersView";
	}
	
	@PostMapping(value = "/getUser")
	public String usersShowUser(@RequestParam(value="login", required = true) String login, ModelMap model) {
		Service service = new Service();
		System.out.println(login);
		model.addAttribute("getEditUser", service.get(new User(login)));
		return "UsersView";
	}
	
	@PostMapping(value = "/getUsers")
	public String usersShowUsers(ModelMap model) {
		Service service = new Service();
		model.addAttribute("listUser", service.getAll());
		return "UsersView";
	}
	


}

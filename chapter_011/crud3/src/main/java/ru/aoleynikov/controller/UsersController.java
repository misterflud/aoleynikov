package ru.aoleynikov.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Anton on 29.06.2017.
 */
@Controller
public class UsersController {
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String start(ModelMap model) {
    	model.addAttribute("ad", "ad"); // добавили аттрибут ad со значением ad 
    	return "RegView";
    }
    
    
}

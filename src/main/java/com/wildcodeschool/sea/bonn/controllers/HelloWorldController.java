package com.wildcodeschool.sea.bonn.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/avengers/assemble")
    public String hello() {
        return "Avengers..... Assemble";
    }
    
    @GetMapping("/secret-bases")
    public String admin() {
        return "France\n" + 
        		"Biarritz\n" + 
        		"Bordeaux\n" + 
        		"La Loupe\n" + 
        		"Lille\n" + 
        		"Lyon\n" + 
        		"Marseille\n" + 
        		"Nantes\n" + 
        		"Orléans\n" + 
        		"Paris\n" + 
        		"Reims\n" + 
        		"Strasbourg\n" + 
        		"Toulouse\n" + 
        		"Tours\n" + 
        		"Amsterdam\n" + 
        		"Barcelone\n" + 
        		"Berlin\n" + 
        		"Bruxelles\n" + 
        		"Bucarest\n" + 
        		"Budapest\n" + 
        		"Dublin\n" + 
        		"Lisbonne\n" + 
        		"Londres\n" + 
        		"Madrid\n" + 
        		"Milan";
    }

}
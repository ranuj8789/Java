package com.test.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.boot.enums.ErrorType;
import com.test.spring.boot.exception.CommonsException;
import com.test.spring.boot.exception.UnknownException;




@RestController
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) throws CommonsException   {    	
    	throw new CommonsException(ErrorType.LOG0001);  	    	
       // return  "hello ranuj dev tools";
}
    @RequestMapping("/greeting2")
    public String greeting2(@RequestParam(value="name", defaultValue="World") String name) {    	
    	throw new UnknownException();  	    	
       // return  "hello ranuj dev tools";
}
    @RequestMapping("/greeting3")
    public String greeting3(@RequestParam(value="name", defaultValue="World") String name) {    	
    	int i =1/0;
    	return "hello" + String.valueOf(i);       
 }
}
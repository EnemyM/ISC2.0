package com.springapp.mvc.configuration.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Anton on 07.03.2016.
 */
@Controller
public class SecondPageController {
    @RequestMapping(value = {"/secondPage"})
    public String getSecondPage(){
        return "secondPage";
    }

    @RequestMapping(value = {"/order/"}, method = RequestMethod.POST)
    public void crOrder(){
        System.out.println("Inside of the order");
    }
}

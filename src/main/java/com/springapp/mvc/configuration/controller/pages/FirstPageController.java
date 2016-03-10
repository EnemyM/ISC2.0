package com.springapp.mvc.configuration.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Anton on 07.03.2016.
 */
@Controller
public class FirstPageController {

    @RequestMapping(value = {"/home","/firstPage"})
    public String firstPage(){

        return "firstPage";
    }
}

package com.springapp.mvc.controller.navigationControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Anton on 02.06.2016.
 */
@Controller
public class RegistrationController {

    @RequestMapping(value = {"/registration"})
    public String getRegistration(){
        return "registration";
    }
}

package com.springapp.mvc.controller.navigationControllers;

import com.springapp.mvc.model.user.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Anton on 07.03.2016.
 */
@Controller
public class StatPageController {
    @RequestMapping(value = {"/secondPage"})
    public String getSecondPage(){
        return "secondPage";
    }

    @RequestMapping(value = {"http://localhost:8080/registration/"}, method = RequestMethod.POST)
    public void crOrder(@PathVariable user user,BindingResult result,
                        ModelMap model){
        System.out.println("Inside of the order");
        System.out.println(user.getFirst_name());
        System.out.println();
    }
}

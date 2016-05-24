package com.springapp.mvc.controller.navigationControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Anton on 07.03.2016.
 */
@Controller
public class StatisticPageController {
    @RequestMapping(value = {"/statistic"})
    public String getStaticPage(){
        return "StatisticPage";
    }

}

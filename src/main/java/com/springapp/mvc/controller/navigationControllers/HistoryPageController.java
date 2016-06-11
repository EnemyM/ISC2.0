package com.springapp.mvc.controller.navigationControllers;

import com.springapp.mvc.model.order.order;
import com.springapp.mvc.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 23.05.2016.
 */
@Controller
public class HistoryPageController {

    @Autowired
    OrderService orderService;

    private static List<order> orders;
    static {
        orders = testOrders();
    }
    @RequestMapping(value = {"/history"})
    public String getHistoryPage(){
        return "HistoryPage";

    }
     /*load list of created orders*/
    @ModelAttribute("orders")
    public List<order> listOrders(){
        /*return orderService.findAllOrders();*/
        return orders;
    }


    private static List<order> testOrders(){
        List<order> orders = new ArrayList<order>();

        for (int i = 0; i < 24;i++){
            orders.add(new order(i,"2016-2-2","8:00","2016-2-1","13000.0"));
        }
        return orders;
    }

}

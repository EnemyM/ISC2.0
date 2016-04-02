package com.springapp.mvc.controller.navigationControllers;

import com.springapp.mvc.model.order.products_order.product;
import com.springapp.mvc.model.order.products_order.product_order;
import com.springapp.mvc.model.order.transport;
import com.springapp.mvc.services.order.TransportService;
import com.springapp.mvc.services.order.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 07.03.2016.
 */
@Controller
public class OrderPageController {


    private static List<product_order> products = new ArrayList<product_order>();

    @Autowired
    ProductService productService;

    @Autowired
    TransportService transportService;

    @RequestMapping(value = {"/home","/firstPage","/"})
    public String firstPage(Model product){

        /*product_order product_order = new product_order();

        product.addAttribute("product_order", product_order);
        product.addAttribute("products", products);*/
        return "firstPage";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("product_order") product_order product_order,Model product){

        System.out.println("Inside in the order controller");
        System.out.println(product_order.getAmount_product());
        products.add(product_order);
        product.addAttribute("products", products);

        com.springapp.mvc.model.order.products_order.product_order newProduct = new product_order();

        product.addAttribute("product_order", newProduct);
        return "firstPage";
    }

    /*@RequestMapping(value = {"/"}, method = RequestMethod.POST)
    public @ResponseBody String add(@ModelAttribute("product_order") product_order product_order,Model product){
        String str = product_order.getAmount_product();
        return str;
    }*/

    /* sent product model */
    @ModelAttribute("products")
    public List<product> initProducts(){
        return productService.findAllProducts();
    }

    /* sent transport model */
    /*@ModelAttribute("transports")*/
    public List<transport> initTransport(){return transportService.findAllTransports();}

    /*@RequestMapping(value = "/helloWorld.web", method = RequestMethod.GET)
    public ModelAndView printWelcome(@ModelAttribute("user") Users user) {

        ModelAndView mav = new ModelAndView("lazyRowLoad");
        mav.addObject("message", "Hello World!!!");
        return mav;

    }*/

/*
    @RequestMapping(value = {"/countAmount/"})
    public ModelAndView countAmount(@RequestBody order order){
        ModelAndView modelAndView = new ModelAndView();

            modelAndView.addObject("amount", );
        return modelAndView;
    }*/

}

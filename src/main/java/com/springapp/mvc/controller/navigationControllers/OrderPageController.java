package com.springapp.mvc.controller.navigationControllers;

import com.springapp.mvc.model.order.products_order.product;
import com.springapp.mvc.model.order.products_order.product_order;
import com.springapp.mvc.model.order.spot_type;
import com.springapp.mvc.model.order.transport;
import com.springapp.mvc.services.order.SpotTypeService;
import com.springapp.mvc.services.order.TransportService;
import com.springapp.mvc.services.order.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anton on 07.03.2016.
 */
@Controller
public class OrderPageController {

    /* list for added products in order*/
    private static List<product_order> products = new LinkedList<product_order>();

    /* services */
    @Autowired
    ProductService productService;
    @Autowired
    TransportService transportService;
    @Autowired
    SpotTypeService spotTypeService;

    @RequestMapping(value = {"/home","/order","/"})
    public String getOrderPage(){

        return "OrderPage";
    }

     /* load list of the products into the order page */
    @ModelAttribute("products")
    public List<product> initProducts(){return productService.findAllProducts();}

     /* load list of the transports into the order page*/
    @ModelAttribute("transports")
    public List<transport> initTransports(){return transportService.findAllTransports();}

    /* load list of the spot types to initialize marker on the map into the order page */
    @ModelAttribute("spot_types")
    public List<spot_type> initSpotTypes(){return spotTypeService.findAll();}

}

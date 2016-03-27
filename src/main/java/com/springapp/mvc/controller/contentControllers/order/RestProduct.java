package com.springapp.mvc.controller.contentControllers.order;

import com.springapp.mvc.model.order.products_order.product_order;
import com.springapp.mvc.services.order.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 23.03.2016.
 */
@RestController
public class RestProduct {

    @Autowired
    ProductService productService;

    private static List<product_order> productsOrder = new ArrayList<product_order>();


    @RequestMapping(value = {"/product/"}, method = RequestMethod.GET)
    public ResponseEntity<List<product_order>> listProduct(){

        com.springapp.mvc.model.order.products_order.product_order product_order1 = new product_order();

        product_order1.setAmount_product(new String("100"));
        product_order1.setProduct(productService.findProductById(1));
        System.out.println("Product  = " + product_order1.getProduct().getProduct_name());
        product_order1.setPrice_amount(new String("100"));

        productsOrder.add(product_order1);

        return new ResponseEntity<List<product_order>>(productsOrder, HttpStatus.OK);
    }
    @RequestMapping(value = {"/product/"},method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> addProduct(@RequestBody() String product_order,UriComponentsBuilder ucBuilder, Model products){

        System.out.println(product_order.toString());
        System.out.println("inside of");

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}

package com.springapp.mvc.controller.contentControllers.order;

import com.springapp.mvc.model.order.products_order.product;
import com.springapp.mvc.model.order.products_order.product_order;
import com.springapp.mvc.services.order.OrderService;
import com.springapp.mvc.services.order.product.ProductService;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton Mostipan on 23.03.2016.
 *  server side rest controller getting request with data from the angularJS in the client side.
 */
@RestController
public class RestProduct {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    private static List<product_order> productsOrder = new ArrayList<product_order>();


    @RequestMapping(value = {"/product/"}, method = RequestMethod.GET)
    public ResponseEntity<List<product_order>> listProduct(){
        return new ResponseEntity<List<product_order>>(productsOrder, HttpStatus.OK);
    }
    @RequestMapping(value = {"/product/"},method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> addProduct(@RequestBody() String product_order,UriComponentsBuilder ucBuilder, Model products){
        System.out.println("Before new mapper");
        /* create mapper to red json from the string value*/
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("After new mapper");
        /* new instance of the entity product order */
        com.springapp.mvc.model.order.products_order.product_order newProduct = null;
        try {
            newProduct = mapper.readValue(product_order, com.springapp.mvc.model.order.products_order.product_order.class);
            product reqProduct = productService.findProductByName(newProduct.getProduct_name());
            System.out.println("Found product is " + reqProduct.getProduct_name());
                Double amount = Double.parseDouble(newProduct.getAmount_product());
            newProduct.setProduct(reqProduct);
            newProduct.setPrice_amount(reqProduct.getProduct_cost() * amount);
            System.out.println("Prise amount of the product " + newProduct.getPrice_amount());
            productsOrder.add(newProduct);
        }  catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @RequestMapping(value = {"/order/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> addOrder(@RequestBody String sentOrder){
        System.out.println(sentOrder.toString());
        /* create mapper to red json from the string value*//*
        ObjectMapper mapper = new ObjectMapper();
        *//* new instance of the entity order*//*
        order newOrder = null;

        try {
            newOrder = mapper.readValue(sentOrder, com.springapp.mvc.model.order.order.class);
            newOrder.setProducts_order(productsOrder);
            orderService.saveOrder(newOrder);
            productsOrder = null; // cleaning products list
        }  catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println("Saving order successful");
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}

package com.springapp.mvc.controller.contentControllers.order;

import com.springapp.mvc.model.order.order;
import com.springapp.mvc.model.order.order_spot;
import com.springapp.mvc.model.order.products_order.product_order;
import com.springapp.mvc.services.order.OrderService;
import com.springapp.mvc.services.order.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton Mostipan on 23.03.2016.
 *  server side rest controller getting request with data from the angularJS in the client side.
 */
@RestController
public class RestOrder {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    private static List<product_order> productsOrder = new ArrayList<product_order>();


    @RequestMapping(value = {"/order/product/"}, method = RequestMethod.GET)
    public ResponseEntity<List<product_order>> listProduct(){
        return new ResponseEntity<List<product_order>>(productsOrder, HttpStatus.OK);
    }

    /* Add product order into the set of order */
    @RequestMapping(value = {"/order/product/"},method = RequestMethod.POST)
    public ResponseEntity<Void> addProduct(@RequestBody product_order product){
        System.out.println(product.toString());
        System.out.println("Product order has been added ");

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /* Create order spot and add it into set of route spots */
    @RequestMapping(value = {"order/order_spot/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> addOrderSpot(@Valid @RequestBody order_spot spot){
        System.out.println(spot.toString());
        System.out.println("Order spot has been created");
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /* Create new order */
    @RequestMapping(value = {"/order/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> addOrder(@RequestBody order sentOrder){
        System.out.println(sentOrder.toString());
        System.out.println("Order has been created");

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}

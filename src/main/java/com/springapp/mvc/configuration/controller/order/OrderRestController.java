package com.springapp.mvc.configuration.controller.order;

import com.springapp.mvc.model.order.order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Anton on 08.03.2016.
 */
@RestController
public class OrderRestController {

   /* @RequestMapping(value = {"/order/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> createOrder(){

        System.out.println("Inside of the order rest controller");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }*/

    @RequestMapping(value = {"/orde/"}, method = RequestMethod.POST)
    public void createOrder(@RequestBody order order){
        System.out.println("inside of the order controller");
        System.out.println(order.toString());
    }
}

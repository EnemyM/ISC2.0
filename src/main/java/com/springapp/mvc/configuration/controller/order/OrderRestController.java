package com.springapp.mvc.configuration.controller.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Anton on 08.03.2016.
 */
@RestController
public class OrderRestController {

    @RequestMapping(value = {"/order/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> createOrder(){

        System.out.println("Inside of the order rest controller");

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}

package com.springapp.mvc.controller.contentControllers.order;

import com.springapp.mvc.model.order.order;
import com.springapp.mvc.model.order.order_spot;
import com.springapp.mvc.model.order.products_order.product;
import com.springapp.mvc.model.order.products_order.product_order;
import com.springapp.mvc.services.order.OrderService;
import com.springapp.mvc.services.order.OrderSpotService;
import com.springapp.mvc.services.order.product.ProductService;
import com.springapp.mvc.services.order.product.ProductsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by Anton Mostipan on 23.03.2016.
 *  server side rest controller getting request with data from the angularJS in the client side.
 */
@RestController
public class RestOrder {

    @Autowired
    ProductService productService;

    @Autowired
    ProductsOrderService productsOrderService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderSpotService orderSpotService;

    /* order products */
    private static Set<product_order> listProductsOrder = new HashSet<product_order>();

    /* order spots */
    private static Set<order_spot> listOrderSpots = new HashSet<order_spot>();

    /* Retrieve all products  */
    @RequestMapping(value = {"/order/product/"}, method = RequestMethod.GET)
    public ResponseEntity<Set<product_order>> listProduct(){
        if(listProductsOrder.isEmpty()){
            System.out.println("List is empty");
            return new ResponseEntity<Set<product_order>>(HttpStatus.NO_CONTENT);
        }
        System.out.println("Sent  list");
        return new ResponseEntity<Set<product_order>>(listProductsOrder, HttpStatus.OK);
    }

    /* Retrieve single product */
    @RequestMapping(value = {"/order/product/{id_product_order}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<product_order> getProduct(@PathVariable("id_product_order") Integer id){
        System.out.println("Fetching product with id " + id);
        product_order product = productsOrderService.findById(id);
        if(product == null){
            System.out.println("Product order with id " + id + "not found");
            return new ResponseEntity<product_order>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Sent  list");
        return new ResponseEntity<product_order>(product, HttpStatus.OK);
    }

    /* Add product order into the order list */
    @RequestMapping(value = {"/order/product/"},method = RequestMethod.POST)
    public ResponseEntity<Void> addProduct(@RequestBody product_order productOrder){
        System.out.println("Product order has been added ");
        /* get product by name*/
        product entity = productService.findProductByName(productOrder.getProduct_name());
        productOrder.setPrice_amount(Double.valueOf(productOrder.getAmount_product()) *
                entity.getProduct_cost());
        listProductsOrder.add(productOrder);
        /*String newAmount  = String.valueOf(Integer.valueOf(entity.getProduct_amount())
                        - Integer.valueOf(productOrder.getAmount_product()));

        System.out.println("New amount product is " + newAmount);
        entity.setProduct_amount(newAmount);*/
        /*productService.updateProductAmount(entity);*/

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/order/product/{product_name}"}, method = RequestMethod.PUT)
    public ResponseEntity<product_order> updateProduct(@PathVariable("product_name") String name, @RequestBody product_order product){
        System.out.println("Updating product order with name " + name);
        for(Iterator<product_order> iterator = listProductsOrder.iterator();iterator.hasNext();){
            product_order itProd = iterator.next();
            if(itProd.getPrice_amount().equals(product.getPrice_amount())){
                try {
                    product entity = productService.findProductByName(itProd.getProduct_name());
                    product.setPrice_amount(Double.valueOf(product.getAmount_product()) *
                            entity.getProduct_cost());
                    /*replace this product with updated*/
                    listProductsOrder.remove(itProd);
                    listProductsOrder.add(product);

                }catch (Exception e){
                    System.out.println("" + e);
                }
            }
        }

        return new ResponseEntity<product_order>(HttpStatus.OK);
    }

    @RequestMapping(value = {"/order/product/{product_name}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable("product_name") String product_name){
        System.out.println("Inside of the delete method ");
        for(Iterator<product_order> iterator = listProductsOrder.iterator();iterator.hasNext();){
            product_order currProd = iterator.next();
            if(currProd.getProduct_name().equals(product_name)){
                System.out.println("delete -------------------------");
                iterator.remove();
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    /* Retrieve all order spots  */
    @RequestMapping(value = {"order/order_spot/"}, method = RequestMethod.GET)
    public ResponseEntity<Set<order_spot>> getOrderSpots(){

        if (listOrderSpots.isEmpty()){
            return new ResponseEntity<Set<order_spot>>(HttpStatus.NO_CONTENT);
        }
        System.out.println("Orders spots sent");
        return new ResponseEntity<Set<order_spot>>(listOrderSpots,HttpStatus.OK);
    }

    /* Create order spot and add it into set of route spots */
    @RequestMapping(value = {"order/order_spot/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> addOrderSpot(@Valid @RequestBody order_spot spot){
        System.out.println("Creating order spot " + spot.toString());

        try{
            listOrderSpots.add(spot);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Order spot has been created");
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /* Fetch all orders*/
    @RequestMapping(value = {"/order/"}, method = RequestMethod.GET)
    public ResponseEntity<List<order>> setOrders(){

        List<order> listOrders = orderService.findAllOrders();

        if(listOrders.isEmpty()){
            return new ResponseEntity<List<order>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<order>>(listOrders,HttpStatus.OK);
    }

    /* Create new order */
    @RequestMapping(value = {"/order/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> addOrder(@RequestBody order sentOrder){
        System.out.println(sentOrder.toString());
        System.out.println("Order has been created");
        listProductsOrder = new HashSet<>();
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}

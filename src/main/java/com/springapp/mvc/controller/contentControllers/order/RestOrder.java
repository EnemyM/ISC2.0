package com.springapp.mvc.controller.contentControllers.order;

import com.springapp.mvc.model.order.*;
import com.springapp.mvc.model.order.products_order.product;
import com.springapp.mvc.model.order.products_order.product_order;
import com.springapp.mvc.model.user.user;
import com.springapp.mvc.services.order.OrderService;
import com.springapp.mvc.services.order.OrderSpotService;
import com.springapp.mvc.services.order.OrderStatusService;
import com.springapp.mvc.services.order.TransportService;
import com.springapp.mvc.services.order.product.ProductService;
import com.springapp.mvc.services.order.product.ProductTypeService;
import com.springapp.mvc.services.order.product.ProductsOrderService;
import com.springapp.mvc.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

    @Autowired
    OrderStatusService orderStatusService;

    @Autowired
    TransportService transportService;

    @Autowired
    UserService userService;

    @Autowired
    ProductTypeService productTypeService;

    /* order products */
    private static Set<product_order> listProductsOrder = new HashSet<product_order>();

    /* order spots */
    private static Set<order_spot> listOrderSpots = new HashSet<order_spot>();

    /* orders */
    private static Set<order> orders = new HashSet<>();

    /*create product */
    @RequestMapping(value = {"/order/product/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> addProduct(@RequestBody product newProduct){
        productService.save(newProduct);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    /* Retrieve all products  */
    @RequestMapping(value = {"/order/product_order/"}, method = RequestMethod.GET)
    public ResponseEntity<Set<product_order>> listProduct(){
        if(listProductsOrder.isEmpty()){
            System.out.println("List is empty");
            return new ResponseEntity<Set<product_order>>(HttpStatus.NO_CONTENT);
        }
        System.out.println("Sent  list");
        return new ResponseEntity<Set<product_order>>(listProductsOrder, HttpStatus.OK);
    }

    /* Retrieve single product */
    @RequestMapping(value = {"/order/product_order/{id_product_order}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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
    @RequestMapping(value = {"/order/product_order/"},method = RequestMethod.POST)
    public ResponseEntity<Void> addOrderProduct(@RequestBody product_order productOrder){
        System.out.println("Product order has been added ");
        /* get product by name*/
        product entity = productService.findProductByName(productOrder.getProduct_name());
        productOrder.setPrice_amount(Double.valueOf(productOrder.getAmount_product()) *
                Double.valueOf(entity.getProduct_cost()));

        listProductsOrder.add(productOrder);

        try {
            order newOrder = new order();
            newOrder.setTime_delivery("8-00");
            newOrder.setDate_delivery("2016-02-10");

            newOrder.setDate_order("2016-02-10");
            newOrder.setPrice_order("222222");

            order_status status = orderStatusService.findTypeByName("Created");
            newOrder.setOrder_status(status);

            transport transport = transportService.findTransportByName("Mercedes-Benz C12");
            newOrder.setTransport(transport);

            user currentUser = userService.findByEmail("fishing94@mail.ru");
            newOrder.setUser(currentUser);

            orderService.saveOrder(newOrder);

        }catch (Exception e){
            System.out.println(e);
        }

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/order/product_order/{product_name}"}, method = RequestMethod.PUT)
    public ResponseEntity<product_order> updateProduct(@PathVariable("product_name") String name, @RequestBody product_order product){
        System.out.println("Updating product order with name " + name);
        for(Iterator<product_order> iterator = listProductsOrder.iterator();iterator.hasNext();){
            product_order itProd = iterator.next();
            if(itProd.getPrice_amount().equals(product.getPrice_amount())){
                try {
                    product entity = productService.findProductByName(itProd.getProduct_name());
                    product.setPrice_amount(Double.valueOf(product.getAmount_product()) *
                            Double.valueOf(entity.getProduct_cost()));
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

    @RequestMapping(value = {"/order/product_order/{product_name}"}, method = RequestMethod.DELETE)
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
    @RequestMapping(value = {"/order/order_spot/"}, method = RequestMethod.GET)
    public ResponseEntity<Set<order_spot>> getOrderSpots(){

        if (listOrderSpots.isEmpty()){
            return new ResponseEntity<Set<order_spot>>(HttpStatus.NO_CONTENT);
        }
        System.out.println("Orders spots sent");
        return new ResponseEntity<Set<order_spot>>(listOrderSpots,HttpStatus.OK);
    }

    /* Create order spot and add it into set of route spots */
    @RequestMapping(value = {"/order/order_spot/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> addOrderSpot(@RequestBody order_spot spot){
        System.out.println("Creating order spot " + spot.toString());

        try{
            spot.setHashCode(spot.hashCode());
            System.out.println("with hash code "+ spot.getHashCode());
            listOrderSpots.add(spot);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Order spot has been created");
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    /* update order spot*/
    @RequestMapping(value = {"/order/order_spot/{hashCode}"}, method = RequestMethod.PUT)
    public ResponseEntity<Void> updateOrderSpot(@PathVariable("hashCode") Integer hashCode, @RequestBody order_spot updatingSpot){
        System.out.println("Updating order spot with hash code " + hashCode);

        for(Iterator<order_spot> itr = listOrderSpots.iterator(); itr.hasNext(); ){
            order_spot currSpot = itr.next();
            if(currSpot.getHashCode().equals(hashCode)){
                /* replace order spot */
                listOrderSpots.remove(currSpot);
                listOrderSpots.add(updatingSpot);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /* delete order spot */
    @RequestMapping(value = {"/order/order_spot/{address}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteOrderSpot(@PathVariable("address") String address){
        System.out.println("Delete order spot with  address " + address);
        for(Iterator<order_spot> itr = listOrderSpots.iterator(); itr.hasNext();){
            order_spot currSpot = itr.next();
            if(currSpot.getAddress().equals(address)){
                listOrderSpots.remove(currSpot);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    /* delete all orde spots*/
    @RequestMapping(value = {"/order/order_spot/delete_all"}, method = RequestMethod.DELETE)
    public  ResponseEntity<Void> deleteAllOrderSpot(){

        System.out.println("Delete all order spots");
        for(Iterator<order_spot> itr = listOrderSpots.iterator(); itr.hasNext();){
            listOrderSpots.remove(itr.next());
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = {"/order/order_route/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> addOrderRoute(@RequestBody order_route route){

        System.out.println("Creating order route");


        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /* Fetch all orders*/
    @RequestMapping(value = {"/order/"}, method = RequestMethod.GET)
    public ResponseEntity<Set<order>> setOrders(){

        if(orders.isEmpty()){
            System.out.println("Order list is empty");
            return new ResponseEntity<Set<order>>(HttpStatus.NO_CONTENT);
        }
        System.out.println("Sent order list");
        return new ResponseEntity<Set<order>>(orders,HttpStatus.OK);
    }

    /* Create new order */
    @RequestMapping(value = {"/order/"}, method = RequestMethod.POST)
    public ResponseEntity<Void> addOrder(@RequestBody order sentOrder){
        System.out.println(sentOrder.toString());


        order newOrder = sentOrder;
        newOrder.setUser(userService.findById(1));
        newOrder.setOrder_status(orderStatusService.findTypeByName("Created"));
        newOrder.setTransport(transportService.findTransportByName(sentOrder.getName_transport()));
        newOrder.setPrice_order("1000");
        newOrder.setDate_order("22-10-16");
        newOrder.setOrder_spots(listOrderSpots);


        orders.add(newOrder);



        System.out.println("Order has been created");

        /*clear the sets of the product order and order spots*/
        listOrderSpots = new HashSet<>();
        listProductsOrder = new HashSet<product_order>();
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /* save all orders into the date base */
    @RequestMapping(value = {"/order/save_all_orders"}, method = RequestMethod.POST)
    public ResponseEntity<Void> saveOrders(){
        for (Iterator<order> itr = orders.iterator();itr.hasNext();){
                order current = itr.next();
            orderService.saveOrder(current);
        }

        /*clean orders */
        orders = new HashSet<>();
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /* create trasnport*/
    @RequestMapping(value = {"/order/transport"}, method = RequestMethod.POST)
    public ResponseEntity<Void> createTransport(@RequestBody transport tr){
        System.out.println("Trasnport " + tr.getName_transport() + "Created");
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


}

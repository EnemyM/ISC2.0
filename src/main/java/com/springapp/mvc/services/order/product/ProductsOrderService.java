package com.springapp.mvc.services.order.product;

import com.springapp.mvc.model.order.products_order.product_order;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
public interface ProductsOrderService {
    product_order findById(int id_order);
    List<product_order> findAllProducts();


    void updateProductOrder(product_order product);
    void save(product_order products_order);
    void deleteById(int id_product);
}

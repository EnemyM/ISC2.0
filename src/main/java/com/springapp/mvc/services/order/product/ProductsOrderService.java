package com.springapp.mvc.services.order.product;

import com.springapp.mvc.model.order.products_order.products_order;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
public interface ProductsOrderService {
    products_order findById(int id_order);
    List<products_order> findAllProducts();

    void save(products_order products_order);
    void deleteById(int id_product);
}

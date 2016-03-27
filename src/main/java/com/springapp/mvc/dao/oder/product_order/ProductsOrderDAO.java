package com.springapp.mvc.dao.oder.product_order;

import com.springapp.mvc.model.order.products_order.product_order;

import java.util.List;

/**
 * Created by Anton on 05.02.2016.
 */
public interface ProductsOrderDAO {
    product_order findById(int id_order);
    List<product_order> findAll();

    void save(product_order products_order);
    void deleteById(int id_product);
}

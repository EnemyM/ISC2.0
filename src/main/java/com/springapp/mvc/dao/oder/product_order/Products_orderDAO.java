package com.springapp.mvc.dao.oder.product_order;

import com.springapp.mvc.model.order.products_order.products_order;

import java.util.List;

/**
 * Created by Anton on 05.02.2016.
 */
public interface Products_orderDAO {
    products_order findById(int id_order);
    List<products_order> findAll();
}

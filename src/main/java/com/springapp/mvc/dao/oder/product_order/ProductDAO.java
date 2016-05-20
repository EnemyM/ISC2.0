package com.springapp.mvc.dao.oder.product_order;

import com.springapp.mvc.model.order.products_order.product;

import java.util.List;

/**
 * Created by Anton on 05.02.2016.
 */
public interface ProductDAO {
    product findByName(String name);
    product findById(int id_product);

    void save(product product);



    void deleteById(int id_product);
    List<product> findAllProducts();
}

package com.springapp.mvc.dao.oder.product_order;

import com.springapp.mvc.model.order.products_order.product_type;

import java.util.List;

/**
 * Created by Anton on 05.02.2016.
 */
public interface Product_typeDAO {
    List<product_type> findAllTypes();
    product_type findById(int id_product_type);
    void save(product_type product_type);
    void deleteByID(int id_product_type);
}

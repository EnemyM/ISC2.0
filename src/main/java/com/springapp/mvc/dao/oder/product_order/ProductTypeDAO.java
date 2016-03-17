package com.springapp.mvc.dao.oder.product_order;

import com.springapp.mvc.model.order.products_order.product_type;

import java.util.List;

/**
 * Created by Anton on 05.02.2016.
 */
public interface ProductTypeDAO {
    List<product_type> findAllTypes();
    product_type findById(int id_product_type);
    product_type findByName(String type_product);
    void save(product_type product_type);
    void deleteByID(int id_product_type);
}

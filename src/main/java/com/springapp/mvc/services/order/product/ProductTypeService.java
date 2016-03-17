package com.springapp.mvc.services.order.product;

import com.springapp.mvc.model.order.products_order.product_type;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
public interface ProductTypeService {

    product_type findTypeById(int id_type);
    product_type findTYpeByName(String type);
    List<product_type> findAllTypes();

    void save(product_type product_type);
    void deleteById(int id_product_type);
}

package com.springapp.mvc.services.order.product;

import com.springapp.mvc.model.order.products_order.product;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
public interface ProductService {

    product findProductById(int id_product);
    product findProductByName(String name_product);
    List<product> findAllProducts();

    void updateProductAmount(product newProduct);
    void save(product product);
    void deleteById(int id_product);
}

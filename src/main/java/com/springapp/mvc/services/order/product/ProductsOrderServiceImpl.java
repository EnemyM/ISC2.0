package com.springapp.mvc.services.order.product;

import com.springapp.mvc.dao.oder.product_order.ProductsOrderDAO;
import com.springapp.mvc.model.order.products_order.product_order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
@Service("productsOrder")
@Transactional
public class ProductsOrderServiceImpl implements ProductsOrderService{

    @Autowired
    private ProductsOrderDAO productsOrderDAO;


    @Override
    public product_order findById(int id_order) {
        return productsOrderDAO.findById(id_order);
    }

    @Override
    public List<product_order> findAllProducts() {
        return productsOrderDAO.findAll();
    }

    @Override
    public void save(product_order products_order) {
        productsOrderDAO.save(products_order);
    }

    @Override
    public void deleteById(int id_product) {
        productsOrderDAO.deleteById(id_product);
    }
}

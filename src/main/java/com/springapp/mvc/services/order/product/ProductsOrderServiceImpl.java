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

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    @Override
    public void updateProductOrder(product_order product) {
        product_order entity = productsOrderDAO.findById(product.getId_product_order());
        if( entity != null){
            entity.setAmount_product(product.getAmount_product());
        }
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

package com.springapp.mvc.services.order.product;

import com.springapp.mvc.dao.oder.product_order.ProductDAO;
import com.springapp.mvc.model.order.products_order.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDAO productDAO;
    @Override
    public product findProductById(int id_product) {
        return productDAO.findById(id_product);
    }

    @Override
    public product findProductByName(String name_product) {
        return productDAO.findByName(name_product);
    }

    @Override
    public List<product> findAllProducts() {
        return productDAO.findAllProducts();
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    @Override
    public void updateProductAmount(product newProduct) {
        product product = productDAO.findById(newProduct.getId_product());
            if( product != null){
            product.setProduct_amount(newProduct.getProduct_amount());
        }
    }

    @Override
    public void save(product product) {
        productDAO.save(product);
    }

    @Override
    public void deleteById(int id_product) {
        productDAO.deleteById(id_product);
    }
}

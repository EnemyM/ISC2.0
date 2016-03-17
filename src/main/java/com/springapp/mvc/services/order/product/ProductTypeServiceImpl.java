package com.springapp.mvc.services.order.product;

import com.springapp.mvc.dao.oder.product_order.ProductTypeDAO;
import com.springapp.mvc.model.order.products_order.product_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
@Service("productTypeService")
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService{
    @Autowired
    private ProductTypeDAO productTypeDAO;

    @Override
    public product_type findTypeById(int id_type) {
        return productTypeDAO.findById(id_type);
    }

    @Override
    public product_type findTYpeByName(String type) {
        return productTypeDAO.findByName(type);
    }

    @Override
    public List<product_type> findAllTypes() {
        return productTypeDAO.findAllTypes();
    }

    @Override
    public void save(product_type product_type) {
        productTypeDAO.save(product_type);
    }

    @Override
    public void deleteById(int id_product_type) {
        productTypeDAO.deleteByID(id_product_type);
    }
}

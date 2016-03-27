package com.springapp.mvc.dao.oder.product_order;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.products_order.product_order;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
@Repository("productsOrderDAO")
public class ProductsOrderDAOImpl extends AbstractDao<Integer,product_order> implements ProductsOrderDAO{


    @Override
    public product_order findById(int id_order) {
        product_order product = getByKey(id_order);
        return product;
    }

    @Override
    public List<product_order> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id_order"));
        return (List<product_order>)criteria.list();
    }

    @Override
    public void save(product_order products_order) {
        persist(products_order);
    }

    @Override
    public void deleteById(int id_product) {
        product_order product = getByKey(id_product);

        delete(product);
    }
}

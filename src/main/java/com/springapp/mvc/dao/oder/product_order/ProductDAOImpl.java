package com.springapp.mvc.dao.oder.product_order;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.products_order.product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
@Repository("productDAO")
public class ProductDAOImpl extends AbstractDao<Integer,product> implements ProductDAO{


    @Override
    public product findByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("product_name",name));
        product product = (product) criteria.uniqueResult();
        return product;
    }

    @Override
    public product findById(int id_product) {
        product product = getByKey(id_product);
        return product;
    }

    @Override
    public void save(product product) {
        persist(product);
    }

    @Override
    public void deleteById(int id_product) {
        product product = getByKey(id_product);
        delete(product);
    }

    @Override
    public List<product> findAllProducts() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("product_name"));
        return (List<product>)criteria.list();
    }
}

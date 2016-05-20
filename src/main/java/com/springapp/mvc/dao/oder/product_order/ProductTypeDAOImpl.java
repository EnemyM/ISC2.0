package com.springapp.mvc.dao.oder.product_order;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.products_order.product_type;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
@Repository("productTypeDAO")
public class ProductTypeDAOImpl extends AbstractDao<Integer,product_type> implements ProductTypeDAO {
    @SuppressWarnings("unchecked")
    @Override
    public List<product_type> findAllTypes() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("product_type"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<product_type> types = (List<product_type>)criteria.list();
        return types;
    }

    @Override
    public product_type findById(int id_product_type) {
        product_type type = getByKey(id_product_type);
        return type;
    }

    @Override
    public product_type findByName(String type_product) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("product_type", type_product));
        return (product_type)criteria.uniqueResult();
    }

    @Override
    public void save(product_type product_type) {
        persist(product_type);
    }

    @Override
    public void deleteByID(int id_product_type) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_product_type",id_product_type));
        product_type type = (product_type)criteria.uniqueResult();
        delete(type);
    }
}

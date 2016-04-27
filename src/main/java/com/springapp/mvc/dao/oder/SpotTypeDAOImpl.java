package com.springapp.mvc.dao.oder;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.spot_type;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 26.04.2016.
 */
@Repository("spotTypeDAO")
public class SpotTypeDAOImpl extends AbstractDao<Integer,spot_type> implements SpotTypeDAO{


    @Override
    public spot_type findSpotTypeById(int id_spot_type) {

        return (spot_type) getByKey(id_spot_type);
    }

    @Override
    public spot_type findSpotTypeByType(String type) {

        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("type",type));
        return (spot_type) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<spot_type> findAllSpotTypes() {

        Criteria criteria = createEntityCriteria().addOrder(Order.asc("type"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<spot_type>) criteria.list();
    }

    @Override
    public void saveSpotType(spot_type spot_type) {
        persist(spot_type);
    }

    @Override
    public void deleteSpotTypeById(int id_spot_type) {

        delete((spot_type)getByKey(id_spot_type));
    }
}

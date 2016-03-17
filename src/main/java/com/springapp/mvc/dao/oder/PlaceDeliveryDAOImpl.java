package com.springapp.mvc.dao.oder;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.place_delivery;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 16.03.2016.
 */
@Repository("placeDeliveryDAO")
public class PlaceDeliveryDAOImpl extends AbstractDao<Integer, place_delivery> implements PlaceDeliveryDAO{
    @Override
    public place_delivery findById(int id_place_delivery) {
        place_delivery place = getByKey(id_place_delivery);
        return place;
    }

    @Override
    public List<place_delivery> findAllPlacesDelivery() {

        Criteria criteria = createEntityCriteria().addOrder(Order.asc("place_delivery"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<place_delivery> places = (List<place_delivery>) criteria.list();
        return places;
    }


    @Override
    public void save(place_delivery place_delivery) {
            persist(place_delivery);
    }

    @Override
    public void deleteById(int id_place_store) {
            Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_place_store",id_place_store));
        place_delivery place = (place_delivery) criteria.uniqueResult();
        delete(place);
    }
}

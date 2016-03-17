package com.springapp.mvc.dao.oder;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.place_store;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 16.03.2016.
 */
@Repository("placeStoreDAO")
public class PlaceStoreDAOImpl extends AbstractDao<Integer, place_store> implements PlaceStoreDAO{
    @Override
    public place_store findById(int id_place_store) {
        place_store place_store = getByKey(id_place_store);
        return place_store;
    }

    @Override
    public List<place_store> findAllPlacesStore() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("place_store"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<place_store> places = (List<place_store>)criteria.list();// to avoid duplicates
        return places;
    }
    @Override
    public place_store findByCoords(float place_latitude, float place_longitude) {
        List<place_store> places = findAllPlacesStore();
        place_store place_store = new place_store();
        for(com.springapp.mvc.model.order.place_store placeStore:places){
            if(placeStore.getPlace_latitude().equals(place_latitude) && placeStore.getPlace_longitude().equals(place_longitude)){
                place_store = placeStore;
            }
        }

        return place_store;
    }

    @Override
    public void save(place_store place_store) {
        persist(place_store);
    }

    @Override
    public void deleteById(int id_place_store) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id_palace_store",id_place_store));
        place_store place_store = (place_store)criteria.uniqueResult();
        delete(place_store);
    }
}

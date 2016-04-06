package com.springapp.mvc.services.order;

import com.springapp.mvc.dao.oder.PlaceStoreDAO;
import com.springapp.mvc.model.order.place_store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
@Service("placeStoreService")
@Transactional
public class PlaceStoreServiceImpl implements PlaceStoreService{

    @Autowired
    private PlaceStoreDAO placeStoreDAO;

    @Override
    public place_store findPlaceById(int id_place_store) {
        return placeStoreDAO.findById(id_place_store);
    }

    @Override
    public place_store findPlaceByCoords(float place_latitude, float place_longitude) {
        return placeStoreDAO.findByCoords(place_latitude,place_longitude);
    }

    @Override
    public List<place_store> findAllPlacesStore() {
        return placeStoreDAO.findAllPlacesStore();
    }

    @Override
    public void save(place_store place_store) {
        placeStoreDAO.save(place_store);
    }

    @Override
    public void deleteById(int id_place_store) {
        placeStoreDAO.deleteById(id_place_store);
    }
}

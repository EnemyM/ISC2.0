package com.springapp.mvc.dao.oder;

import com.springapp.mvc.model.order.place_store;

import java.util.List;

/**
 * Created by Anton on 05.02.2016.
 */
public interface PlaceStoreDAO {

    place_store findById(int id_place_store);
    place_store findByCoords(float place_latitude, float place_longitude);
    List<place_store> findAllPlacesStore();

    void save(place_store place_store);
    void  deleteById(int id_place_store);

}

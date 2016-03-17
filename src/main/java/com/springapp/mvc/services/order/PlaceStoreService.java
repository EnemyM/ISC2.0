package com.springapp.mvc.services.order;

import com.springapp.mvc.model.order.place_store;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
public interface PlaceStoreService {

    place_store findPlaceById(int id_place_store);
    place_store findPlaceByCoords(float place_latitude, float place_longitude);
    List<place_store> findAllPlacesStore();

    void save(place_store place_store);
    void deleteById(int id_place_store);
}

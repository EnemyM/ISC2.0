package com.springapp.mvc.dao.oder;

import com.springapp.mvc.model.order.place_delivery;

import java.util.List;

/**
 * Created by Anton on 05.02.2016.
 */
public interface PlaceDeliveryDAO {
    place_delivery findById(int id_place_delivery);
    List<place_delivery> findAllPlacesDelivery();

    void save(place_delivery place_delivery);
    void deleteById(int id_place_delivery);

}

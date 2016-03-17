package com.springapp.mvc.services.order;

import com.springapp.mvc.model.order.place_delivery;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
public interface PlaceDeliveryService {

    place_delivery findPlaceDeliveryById(int id_place_delivery);
    List<place_delivery> findAllPlacesDelivery();

    void save(place_delivery place_delivery);
    void deleteById(int id_place_delivery);
}

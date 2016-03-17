package com.springapp.mvc.services.order;

import com.springapp.mvc.dao.oder.PlaceDeliveryDAO;
import com.springapp.mvc.model.order.place_delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
@Service("placeDeliveryService")
@Transactional
public class PlaceDeliveryServiceImpl implements PlaceDeliveryService{
    @Autowired
    private PlaceDeliveryDAO placeDeliveryDAO;

    @Override
    public place_delivery findPlaceDeliveryById(int id_place_delivery) {
        return placeDeliveryDAO.findById(id_place_delivery);
    }

    @Override
    public List<place_delivery> findAllPlacesDelivery() {
        return placeDeliveryDAO.findAllPlacesDelivery();
    }

    @Override
    public void save(place_delivery place_delivery) {
        placeDeliveryDAO.save(place_delivery);
    }

    @Override
    public void deleteById(int id_place_delivery) {
        placeDeliveryDAO.deleteById(id_place_delivery);
    }
}

package com.springapp.mvc.services.order;

import com.springapp.mvc.model.order.spot_type;

import java.util.List;

/**
 * Created by Anton on 26.04.2016.
 */
public interface SpotTypeService {
    spot_type findById(int id_spot_type);
    spot_type findByType(String type);

    List<spot_type> findAll();

    void save(spot_type spot_type);
    void deleteById(int id_spot_type);
}

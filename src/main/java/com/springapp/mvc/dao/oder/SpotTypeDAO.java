package com.springapp.mvc.dao.oder;

import com.springapp.mvc.model.order.spot_type;

import java.util.List;

/**
 * Created by Anton on 26.04.2016.
 */
public interface SpotTypeDAO {

    spot_type findSpotTypeById(int id_spot_type);

    spot_type findSpotTypeByType(String type);

    List<spot_type> findAllSpotTypes();

    void saveSpotType(spot_type spot_type);
    void deleteSpotTypeById(int id_spot_type);
}

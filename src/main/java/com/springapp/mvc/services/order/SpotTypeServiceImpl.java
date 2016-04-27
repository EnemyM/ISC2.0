package com.springapp.mvc.services.order;

import com.springapp.mvc.dao.oder.SpotTypeDAO;
import com.springapp.mvc.model.order.spot_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 26.04.2016.
 */
@Service("spotTypeService")
@Transactional
public class SpotTypeServiceImpl implements SpotTypeService{

    @Autowired
    private SpotTypeDAO dao;

    @Override
    public spot_type findById(int id_spot_type) {
        return dao.findSpotTypeById(id_spot_type);
    }

    @Override
    public spot_type findByType(String type) {
        return dao.findSpotTypeByType(type);
    }

    @Override
    public List<spot_type> findAll() {
        return dao.findAllSpotTypes();
    }

    @Override
    public void save(spot_type spot_type) {
        dao.saveSpotType(spot_type);
    }

    @Override
    public void deleteById(int id_spot_type) {
        dao.deleteSpotTypeById(id_spot_type);
    }
}

package com.springapp.mvc.services.order;

import com.springapp.mvc.dao.oder.OrderSpotDAO;
import com.springapp.mvc.model.order.order_spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 26.04.2016.
 */
@Service("orderSpotService")
@Transactional
public class OrderSpotServiceImpl implements OrderSpotService{
    @Autowired
    private OrderSpotDAO dao;

    @Override
    public order_spot findById(int id_order_spot) {
        return dao.findOrderSpotById(id_order_spot);
    }

    @Override
    public order_spot findByType(String type) {
        return dao.findOrderSpotByAddress(type);
    }

    @Override
    public List<order_spot> findAll() {
        return dao.finaAllOrderSpots();
    }

    @Override
    public void save(order_spot order_spot) {
        dao.saveOrderSpot(order_spot);
    }

    @Override
    public void deleteById(int id_order_spot) {
        dao.deleteOrderSpot(id_order_spot);
    }
}

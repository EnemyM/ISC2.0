package com.springapp.mvc.services.order;

import com.springapp.mvc.dao.oder.OrderStatusDAO;
import com.springapp.mvc.model.order.order_status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 17.03.2016.
 */
@Service("orderStatusService")
@Transactional
public class OrderStatusServiceImpl implements OrderStatusService{


    @Autowired
    private OrderStatusDAO dao;


    @Override
    public order_status findStatusById(int id_status) {
        return dao.findById(id_status);
    }

    @Override
    public order_status findTypeByName(String status) {
        return dao.findByName(status);
    }

    @Override
    public List<order_status> findAllTypes() {
        return null;
    }

    @Override
    public void save(order_status status) {
        dao.save(status);
    }

    @Override
    public void deleteById(int id_order_status) {
        dao.deleteById(id_order_status);
    }
}

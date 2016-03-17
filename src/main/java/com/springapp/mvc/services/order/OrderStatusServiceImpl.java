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
public class OrderStatusServiceImpl implements OrderStatusDAO{

    @Autowired
    private OrderStatusDAO orderStatusDAO;

    @Override
    public order_status findById(int id_status) {
        return orderStatusDAO.findById(id_status);
    }

    @Override
    public List<order_status> findAllStatuses() {
        return orderStatusDAO.findAllStatuses();
    }

    @Override
    public void save(order_status status) {
        orderStatusDAO.save(status);
    }

    @Override
    public void deleteById(int id_order_status) {
        orderStatusDAO.deleteById(id_order_status);
    }
}

package com.springapp.mvc.services.order;

import com.springapp.mvc.dao.oder.OrderDAO;
import com.springapp.mvc.model.order.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * Created by Anton on 16.03.2016.
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public order findById(int id_order) {
        return orderDAO.findById(id_order);
    }

    @Override
    public order findByDateOrder(Date date_order) {
        return orderDAO.findByDate(date_order);
    }


    @Override
    public List<order> findAllOrders() {
        return orderDAO.findAllOrders();
    }

    @Override
    public void saveOrder(order order) {
        orderDAO.save(order);
    }

    @Override
    public void updateOrder(order order) {
        order entity = orderDAO.findById(order.getId_order());
        if(entity != null){
            entity.setDate_delivery(order.getDate_delivery());
            entity.setDate_order(order.getDate_order());
            entity.setOrder_status(order.getOrder_status());
            entity.setOrder_spots(order.getOrder_spots());
            entity.setPrice_order(order.getPrice_order());
            entity.setTime_delivery(order.getTime_delivery());
            entity.setProducts_order(order.getProducts_order());
        }
    }

    @Override
    public void deleteOrderById(int id_order) {
        orderDAO.deleteById(id_order);
    }
}

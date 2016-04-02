package com.springapp.mvc.services.order;

import com.springapp.mvc.dao.oder.TransportDAO;
import com.springapp.mvc.model.order.transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Anton on 28.03.2016.
 */
@Service("transportService")
public class TransportServiceImpl implements TransportService{

    @Autowired
    private TransportDAO transportDAO;

    @Override
    public transport findTransportById(int id_transport) {
        return transportDAO.findTransportById(id_transport);
    }

    @Override
    public transport findTransportByName(String name_transport) {
        return transportDAO.findTransportByName(name_transport);
    }

    @Override
    public List<transport> findAllTransports() {
        return transportDAO.findAllTransports();
    }

    @Override
    public void saveTrasport(transport transport) {
        transportDAO.saveTransport(transport);
    }

    @Override
    public void deleteTransportById(int id_transport) {
        transportDAO.deleteTransportById(id_transport);
    }
}

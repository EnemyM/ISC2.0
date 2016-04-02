package com.springapp.mvc.services.order;

import com.springapp.mvc.model.order.transport;

import java.util.List;

/**
 * Created by Anton on 28.03.2016.
 */
public interface TransportService {

    transport findTransportById(int id_transport);
    transport findTransportByName(String name_transport);

    List<transport> findAllTransports();

    void saveTrasport(transport transport);
    void deleteTransportById(int id_transport);
}

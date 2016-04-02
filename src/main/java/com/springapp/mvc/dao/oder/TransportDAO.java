package com.springapp.mvc.dao.oder;

import com.springapp.mvc.model.order.transport;

import java.util.List;

/**
 * Created by Anton on 28.03.2016.
 */
public interface TransportDAO {

    transport findTransportById(int id_transport);
    transport findTransportByName(String name_transport);

    List<transport> findAllTransports();

    void saveTransport(transport transport);
    void deleteTransportById(int id_transport);
}

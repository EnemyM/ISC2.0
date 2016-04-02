package com.springapp.mvc.dao.oder;

import com.springapp.mvc.dao.AbstractDao;
import com.springapp.mvc.model.order.transport;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 28.03.2016.
 */
@Repository("transportDAO")
public class TransportDAOImpl extends AbstractDao<Integer,transport> implements TransportDAO {
    @Override
    public transport findTransportById(int id_transport) {
        return getByKey(id_transport);
    }

    @Override
    public transport findTransportByName(String name_transport) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name_transport", name_transport));
        transport transport = (transport) criteria.uniqueResult();
        return transport;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<transport> findAllTransports() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("name_transport"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<transport> list = (List<transport>) criteria.list();

        return list;
    }

    @Override
    public void saveTransport(transport transport) {
        persist(transport);
    }

    @Override
    public void deleteTransportById(int id_transport) {
        transport transport = getByKey(id_transport);
        delete(transport);
    }
}

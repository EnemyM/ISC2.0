package com.springapp.mvc.services.user.phone;

import com.springapp.mvc.dao.user.phone.PhoneTypeDAO;
import com.springapp.mvc.model.user.phone_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Anton on 30.03.2016.
 */
@Service("phoneTypeService")
public class PhoneTypeServiceImpl implements PhoneTypeService{
    @Autowired
    PhoneTypeDAO phoneTypeDAO;

    @Override
    public phone_type findPhoneTypeById(int id_phone_type) {
        return phoneTypeDAO.findPhoneTypeById(id_phone_type);
    }

    @Override
    public phone_type findPhoneTypeByType(String phone_type) {
        return phoneTypeDAO.findPhoneTYpeByType(phone_type);
    }

    @Override
    public List<phone_type> findAllPhoneTypes() {
        return phoneTypeDAO.findAllPhoneType();
    }

    @Override
    public void save(phone_type phone_type) {
        phoneTypeDAO.savePhoneType(phone_type);
    }

    @Override
    public void deleteById(int id_phone_type) {
            phoneTypeDAO.deletePhoneTypeById(id_phone_type);
    }
}

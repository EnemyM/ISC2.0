package com.springapp.mvc.dao.user.phone;

import com.springapp.mvc.model.user.phone_type;

import java.util.List;

/**
 * Created by Anton on 30.03.2016.
 */
public interface PhoneTypeDAO {

    phone_type findPhoneTypeById(int id_phone_type);

    phone_type findPhoneTYpeByType(String phone_type);

    List<phone_type> findAllPhoneType();

    void savePhoneType(phone_type phone_type);
    void deletePhoneTypeById(int id_phone_type);
}

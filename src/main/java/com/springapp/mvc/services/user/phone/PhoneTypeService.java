package com.springapp.mvc.services.user.phone;

import com.springapp.mvc.model.user.phone_type;

import java.util.List;

/**
 * Created by Anton on 30.03.2016.
 */
public interface PhoneTypeService {
    phone_type findPhoneTypeById(int id_phone_type);

    phone_type findPhoneTypeByType(String phone_type);

    List<phone_type> findAllPhoneTypes();

    void save(phone_type phone_type);

    void deleteById(int id_phone_type);
}

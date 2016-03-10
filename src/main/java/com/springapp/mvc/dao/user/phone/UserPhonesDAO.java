package com.springapp.mvc.dao.user.phone;

import com.springapp.mvc.model.user.user_phones;

import java.util.List;

/**
 * Created by Anton on 27.01.2016.
 */
public interface UserPhonesDAO {
    List<user_phones> findAllPhones();
    user_phones findById(int id_phone);
    user_phones findByNumber(String phone_number);
}

package com.springapp.mvc.services.user.phone;

import com.springapp.mvc.model.user.user_phone;

import java.util.List;

/**
 * Created by Anton on 27.01.2016.
 */
public interface UserPhonesService {
    List<user_phone> findAllPhones();
    user_phone findById(int id_phone);
    user_phone findByNumber(String phone_number);
}

package com.springapp.mvc.services.user.phone;

import com.springapp.mvc.dao.user.phone.UserPhonesDAO;
import com.springapp.mvc.model.user.user_phones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anton on 27.01.2016.
 */
@Service("userPhonesService")
@Transactional
public class UserPhonesServiceImpl implements UserPhonesService {

    @Autowired
    UserPhonesDAO dao;

    public List<user_phones> findAllPhones() {
        return dao.findAllPhones();
    }

    public user_phones findById(int id_phone) {
        return dao.findById(id_phone);
    }

    public user_phones findByNumber(String phone_number) {
        return dao.findByNumber(phone_number);
    }
}

package com.springapp.mvc.services.user.security;

import com.springapp.mvc.dao.user.UserDAO;
import com.springapp.mvc.model.user.user;
import com.springapp.mvc.model.user.user_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Anton on 20.02.2016.
 */
@Service("userDetailsService")
public class MainUserDetailsService implements UserDetailsService{

    @Autowired
    private UserDAO dao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String userEmail)
            throws UsernameNotFoundException {
        user user = dao.findByEmail(userEmail);

        List<GrantedAuthority> authorities = buildUserAuthority(user.getUser_role());
        return buildUserForAuthentication(user,authorities);
    }

    /*
    Convert model.user into security.User
    */
    private User buildUserForAuthentication(user user, List<GrantedAuthority> authorities) {
        return new User(user.getEmail_user(),user.getUser_password(),
                user.isEnabled(),true,true,true,authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<user_role> roles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

//        Build user's authority
        for (user_role userRole: roles){
            setAuths.add(new SimpleGrantedAuthority(userRole.getUser_role()));
        }
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
        return result;
    }


}

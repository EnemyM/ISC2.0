package com.springapp.mvc.controller.contentControllers.registration;

import com.springapp.mvc.services.user.UserService;
import com.springapp.mvc.services.user.role.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Anton on 10.02.2016.*/


@RestController
public class RegistrationRestController {
    @Autowired
    UserService userService;

    @Autowired
    UserRoleService roleService;


    @RequestMapping(value = {"/registration/"}, method = RequestMethod.POST )
    public ResponseEntity<Void> createClient(Object user,UriComponentsBuilder ucBuilder){
        System.out.println("Inside of ");

//        System.out.println(user.getFirst_name());
       /* if (userService.isUserExist(user.getEmail_user())){
            System.out.println("Client with  firm name " + user.getName_firm()+ " is already exist ");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        user.setEnabled(true);
//        System.out.println("before role");

        user_role role = new user_role("ROLE_CLIENT");
        user.addRole(role);

//        System.out.println("after lore");
        userService.saveUser(user);
*/
       /* HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/registration/{id_user}").buildAndExpand(user.getId_user()).toUri());*/
        return new ResponseEntity<Void>(/*headers,*/ HttpStatus.CREATED);
    }

}

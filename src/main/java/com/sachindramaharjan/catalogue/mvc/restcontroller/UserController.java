package com.sachindramaharjan.catalogue.mvc.restcontroller;

import com.sachindramaharjan.catalogue.config.ServerConfig;
import com.sachindramaharjan.catalogue.core.entity.User;
import com.sachindramaharjan.catalogue.core.exception.UserExistException;
import com.sachindramaharjan.catalogue.core.service.UserService;
import com.sachindramaharjan.catalogue.mvc.resources.UserResource;
import com.sachindramaharjan.catalogue.mvc.resources.asm.UserResourceAsm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * Created by sachindra.maharjan on 4/13/16.
 */
@RestController
@RequestMapping(value = "/catalogue/rest")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    ServerConfig config;

    @RequestMapping(value = "/findUser/{username}")
    public ResponseEntity<UserResource> findUserByUsername(@PathVariable String username){
        UserResource res =  null;
        HttpStatus httpStatus = null;

        if(username != null || !username.equals("")){
            User user = userService.findUserByUsername(username);
            res = new UserResourceAsm().toResource(user);
            httpStatus = HttpStatus.OK;
        }else{
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(res, httpStatus);
    }

    @RequestMapping(value = "/findUser/{emaail}")
    public ResponseEntity<UserResource> findUserByEmail(@PathVariable String email){
        UserResource res =  null;
        HttpStatus httpStatus = null;

        if(email != null || !email.equals("")){
            User user = userService.findUserByEmail(email);
            res = new UserResourceAsm().toResource(user);
            httpStatus = HttpStatus.OK;
        }else{
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(res, httpStatus);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserResource> login(@RequestBody UserResource userResource){
        User user = userService.loginUser(userResource.toUser());
        UserResource res = new UserResourceAsm().toResource(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(res.getLink("self").getHref()));

        return new ResponseEntity<>(res, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<UserResource> addUser(@RequestBody UserResource userResource){
        User newUser = null;
        UserResource res = null;
        if(userResource != null){
            try {
                newUser = userService.addUser(userResource.toUser());
                res = new UserResourceAsm().toResource(newUser);
            }catch (UserExistException ex){
                logger.info("Error creating new user.");
                logger.info(ex.getMessage());
            }
        }

        if(res != null) {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(res, HttpStatus.CONFLICT);
        }
    }


}

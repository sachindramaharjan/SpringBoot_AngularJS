package com.sachindramaharjan.catalogue.mvc.resources.asm;

import com.sachindramaharjan.catalogue.core.entity.User;
import com.sachindramaharjan.catalogue.mvc.resources.UserResource;
import com.sachindramaharjan.catalogue.mvc.restcontroller.UserController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by sachindra.maharjan on 4/13/16.
 */
public class UserResourceAsm extends ResourceAssemblerSupport<User, UserResource> {

    public UserResourceAsm(){
        super(UserController.class, UserResource.class);
    }

    /*
    * This method is used to send resource to client
    * */
    @Override
    public UserResource toResource(User user) {
        UserResource userResource = new UserResource();
        userResource.setUsername(user.getUsername());
        userResource.add(linkTo(methodOn(UserController.class).findUser(user.getUsername())).withSelfRel());
        return userResource;
    }
}

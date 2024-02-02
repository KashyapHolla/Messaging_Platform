package com.uta.prattle.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.uta.prattle.model.User;
import com.uta.prattle.service.GroupService;
import com.uta.prattle.service.GroupServiceImpl;
import com.uta.prattle.service.UserService;
import com.uta.prattle.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * A Resource class responsible for handling CRUD operations on User objects.
 *
 * @author CS5500 Fall 2019 Teaching staff
 * @version dated 2019-10-06
 */
@Path("/app")
public class AppController {

    // Usually Dependency injection will be used to inject the service at run-time
    private UserService userService = UserServiceImpl.getInstance();
    private GroupService groupService = GroupServiceImpl.getInstance();

    /**
     * Handles a HTTP GET request to retrieve all users.
     *
     * @return a response indicating the outcome of the request
     */
    @GET
    @Path("/users")
    @Produces("application/json")
    public List<String> getUsers() {
        // try adding a new user
        return getUsernames(userService.findUsers());
    }

    /**
     * Handles a HTTP GET request to retrieve all users.
     *
     * @return a response indicating the outcome of the request
     */
    @GET
    @Path("{username}/groups")
    @Produces("application/json")
    public List<String> getGroups(@PathParam("username") String username) {
        // try adding a new user
        return groupService.findAllGroups(username);
    }


    private List<String> getUsernames(List<User> users) {
        List<String> usernames = new ArrayList<>();
        for (User u : users) {
            usernames.add(u.getUsername());
        }
        return usernames;
    }
}

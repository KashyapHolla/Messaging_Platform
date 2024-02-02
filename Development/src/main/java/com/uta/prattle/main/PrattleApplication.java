package com.uta.prattle.main;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.uta.prattle.controller.AppController;
import com.uta.prattle.controller.GroupController;
import com.uta.prattle.controller.MessageController;
import com.uta.prattle.controller.UserController;
import com.uta.prattle.model.CorsFilter;

import java.util.HashSet;
import java.util.Set;

/***
 * Sets up the resource classes for handling REST requests.
 * Refer {@link Application}
 *
 * @author CS5500 Fall 2019 Teaching staff
 * @version dated 2019-10-06
 */
@ApplicationPath("/")
public class PrattleApplication extends Application {
    private Set<Class<?>> resourceClasses = new HashSet<>();

    @Override
    public Set<Class<?>> getClasses() {
        resourceClasses.add(AppController.class);
        resourceClasses.add(MessageController.class);
        resourceClasses.add(UserController.class);
        resourceClasses.add(GroupController.class);
        resourceClasses.add(CorsFilter.class);
        return resourceClasses;
    }
}

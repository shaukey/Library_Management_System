package com.project.library_mangement_system.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        initDatabaseEntities();
    }

    private void initDatabaseEntities() {
        if( userService.getAllUsers().size() == 0) {
            userService.addNew(new User("Shauki", "Shauki", "Shauki", Constants.ROLE_ADMIN));
            userService.addNew(new User("Mr. Librarian", "librarian", "librarian", Constants.ROLE_LIBRARIAN));
        }
    }
}

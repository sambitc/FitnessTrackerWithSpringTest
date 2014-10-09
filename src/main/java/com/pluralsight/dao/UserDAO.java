package com.pluralsight.dao;

import com.pluralsight.model.DbUser;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    /**
     * Simulates retrieval of data from a database.
     * http://krams915.blogspot.in/2010/12/spring-security-mvc-integration_18.html
     */
    public DbUser searchDatabase(String username, String companyName) {
        // Retrieve all users from the database
        List<DbUser> users = internalDatabase();

        // Search user based on the parameters
        for (DbUser dbUser : users) {
            if (dbUser.getUsername().equals(username) == true && dbUser.getCompanyName().equals(companyName) == true) {
                // return matching user
                return dbUser;
            }
        }
        System.out.println("Not Exists");
        throw new RuntimeException("User does not exist!");
    }

    /**
     * Our fake database. Here we populate an ArrayList with a dummy list of
     * users.
     */
    private List<DbUser> internalDatabase() {
		// Dummy database

        // Create a dummy array list
        List<DbUser> users = new ArrayList<DbUser>();
        DbUser user = null;

        // Create a new dummy user
        user = new DbUser();
        user.setUsername("prasady");
        // Actual password: koala
        user.setPassword("6876f31c02ad2082dd2f7c3fb0b90b90");
        // Admin user
        user.setAccess(1);
        user.setCompanyName("mindfire");

        // Add to array list
        users.add(user);

        // Create a new dummy user
        user = new DbUser();
        user.setUsername("ronalil");
        // Actual password: emu
        user.setPassword("6876f31c02ad2082dd2f7c3fb0b90b90");
        // Regular user
        user.setAccess(2);
        user.setCompanyName("mindfire");

        // Add to array list
        users.add(user);

        // Create a new dummy user
        user = new DbUser();
        user.setUsername("sambitc");
        // Actual password: wombat
        user.setPassword("6876f31c02ad2082dd2f7c3fb0b90b90");
        // Regular user
        user.setAccess(2);
        user.setCompanyName("mindfire");

        // Add to array list
        users.add(user);

        // Create a new dummy user
        user = new DbUser();
        user.setUsername("sambitc");
        // Actual password: wombat
        user.setPassword("6876f31c02ad2082dd2f7c3fb0b90b90");
        // Regular user
        user.setAccess(2);
        user.setCompanyName("xyz");

        // Add to array list
        users.add(user);

        return users;
    }

}

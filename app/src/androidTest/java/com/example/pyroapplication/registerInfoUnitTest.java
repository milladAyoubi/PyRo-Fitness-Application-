package com.example.pyroapplication;
import org.junit.Test;

import static org.junit.Assert.*;


public class registerInfoUnitTest {
    User newUser = new User("barry","m@gmail.com","password1234");

    @Test
    public void testUserEntries()
    {
        String userName = newUser.name;
        String userEmail = newUser.email;
        String userPassword = newUser.password;



        assertTrue(userName.matches("^[a-zA-Z]*$"));
        assertTrue(userEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"));
        assertTrue(userPassword.matches("^[a-zA-Z0-9]*$"));



    }
}

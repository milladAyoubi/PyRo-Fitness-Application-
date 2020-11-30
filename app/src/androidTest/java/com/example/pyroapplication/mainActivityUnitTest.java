package com.example.pyroapplication;




import android.view.View;

import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class mainActivityUnitTest {

    @Rule
    public ActivityTestRule<MainActivity> newLaunchTest = new ActivityTestRule<>(MainActivity.class);
    private MainActivity newLaunch = null;
    @Before
    public void setUp() {
        newLaunch = newLaunchTest.getActivity();
    }
    @Test

    public void testLaunch() {
    View login = newLaunch.findViewById(R.id.login);
    View register = newLaunch.findViewById(R.id.register);
    View reset = newLaunch.findViewById(R.id.resetbtn);

    assertNotNull(login);
    assertNotNull(register);
    assertNotNull(reset);
    }

}
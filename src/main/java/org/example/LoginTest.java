package org.example;

import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void webTest() {
        System.out.println("Web login Test");
    }

    @Test(groups = "smoke")
    public void mobileTest() {
        System.out.println("Mobile login Test");
    }

    @Test
    public void desktopTest() {
        System.out.println("Desktop login Test");
    }
}

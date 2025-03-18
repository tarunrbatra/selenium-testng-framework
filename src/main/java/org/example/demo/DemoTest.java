package org.example.demo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest {

    @BeforeTest
    public void first() {
        System.out.println("Before Test");
    }

    @Test
    public void test1() {
        System.out.println("This is Test1");
    }

    @Test(groups = "smoke")
    public void test2() {
        System.out.println("This is Test2");
    }

    @AfterTest
    public void last() {
        System.out.println("After Test");
    }

}

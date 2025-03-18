package org.example;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestSuccess(ITestResult result) {
        System.out.println("TestListener-onTestSuccess " + result.getName());
    }


}

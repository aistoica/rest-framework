package com.endava.rest.util;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.endava.rest.controller.cart.CartController;
import com.endava.rest.controller.cart.CartUtil;
import com.endava.rest.controller.product.ProductController;
import com.endava.rest.controller.product.ProductUtil;
import com.endava.rest.exceptions.AutomationException;

import io.restassured.RestAssured;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by astoica on 4/28/2015.
 */
public class TestBaseClass {

    protected ProductController productController = new ProductController();
    protected ProductUtil productUtil = new ProductUtil();
    protected CartController cartController = new CartController();
    protected CartUtil cartUtil = new CartUtil();

    @AfterMethod
    private void cleanUpRequest() {
        productController = new ProductController();
    }

    @BeforeClass
    public void setUpRestAssured() {

        String envFile = System.getProperty("env");
        System.out.println("Environment file used is: " + envFile);
        String filePath = "environments/".concat(envFile.concat(".properties"));
        Properties props = new Properties();
        try {
            props.load(this.getClass().getClassLoader().getResourceAsStream(filePath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AutomationException("Could not read property init file", e);
        }

        RestAssured.port = Integer.parseInt(props.getProperty("appPort"));
        RestAssured.baseURI = props.getProperty("appBaseURI");
        RestAssured.basePath = props.getProperty("appBasePath");
    }

    @BeforeMethod
    protected void starting(Method method){
        System.out.println("********************************************************************************");
        System.out.println("Testing: " + method.getName() + "(" + method.getDeclaringClass() + ")");
        System.out.println("********************************************************************************");
    }

    @AfterMethod
    protected void finished(Method method){
        System.out.println("********************************************************************************");
        System.out.println("Done testing: " + method.getName() + "(" + method.getDeclaringClass() + ")");
        System.out.println("********************************************************************************");
    }
}

package com.solvd.taxi.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Singleton {
    private static final Logger LOGGER = LogManager.getLogger(Singleton.class);
    private int test = 5;
    static Singleton singleton = new Singleton();

    private Singleton() {

    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public static Singleton getInstance() {
        return singleton;
    }
    /*private static Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void setUp() {
        System.out.println("Singleton setUp");
    }
*/
}

package org.example.Lab12;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RandomClass {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RandomClass(String name) {
        this.name = name;
    }
    @Test public static void test_method() { }
}

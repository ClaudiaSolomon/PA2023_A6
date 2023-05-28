package org.example.Lab12;

import org.testng.annotations.Test;

@Test
public class TestClass {
    @Test public static void test_method(int a) {
        System.out.println("test fara argumente");
    }
    @Test public void test_with_args(int a,String s){
        System.out.println("test cu argumente");
    }
}

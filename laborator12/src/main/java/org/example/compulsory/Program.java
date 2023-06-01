package org.example.compulsory;

import org.junit.Test;

public class Program {
    public Program() {
    }

    @Test
    public static void method1(int i) {
        System.out.println("This works");
    }

    @Test
    public static void method2() {
        System.out.println("This works");
    }

    @Test
    public static void method3() {
        System.out.println("This works");
    }

    @Test
    public static void method4() {
        throw new RuntimeException("This fails");
    }
}

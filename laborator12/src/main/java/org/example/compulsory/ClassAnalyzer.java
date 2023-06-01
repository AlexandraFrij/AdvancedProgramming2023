package org.example.compulsory;

import org.junit.Test;
import java.util.Arrays;
import java.lang.reflect.Method;

/**
 * used to load extract information about a class
 */
public class ClassAnalyzer {
    private MyClassLoader myClassLoader;
    private Class<?> clazz;

    public ClassAnalyzer() {
        myClassLoader = new MyClassLoader();
    }

    /**
     * extracts info about the class such as package, name, methods
     * @param className   name for the class to be analyzed
     * @throws ClassNotFoundException
     */
    public void extractInfo(String className) throws ClassNotFoundException {
        clazz = myClassLoader.loadClass(className);
        System.out.println("Class's package: " + clazz.getPackage());
        System.out.println("Class's name: " + clazz.getName());
        System.out.println("Class's methods: " + Arrays.toString(clazz.getMethods()));
    }

    /**
     * generates mock int or string arguments for tests
     * @param parameterType  list of parameters' types of a class's method
     * @return  list of int or string values
     */
    public Object[] generateMockArgs(Class<?>[] parameterType) {
        Object[] args = new Object[parameterType.length];
        for (int i = 0; i < parameterType.length; i++) {
            Class<?> type = parameterType[i];
            if (type == int.class) {
                args[i] = 0;
            } else if (type == String.class) {
                args[i] = "mock";
            } else {
                args[i] = null;
            }
        }
        return args;
    }

    /**
     * invokes methods annotated with @Test
     * prints statistics regarding the tests
     */
    public void testClass() {
        int testsPassed = 0;
        int testsFailed = 0;
        for (Method method : clazz.getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    if (method.getParameterCount() == 0) {
                        method.invoke(null);
                        testsPassed++;
                    } else {
                        Object[] args = generateMockArgs(method.getParameterTypes());
                        method.invoke(null, args);
                        testsPassed++;
                    }

                } catch (Throwable e) {
                    testsFailed++;
                }
            }
        }
        int totalTests = testsFailed + testsPassed;
        System.out.println("Total tests: " + totalTests);
        System.out.println("Number of tests passed: " + testsPassed);
        System.out.println("Number of tests failed: " + testsFailed);
        System.out.println("Tests success rate: " + 100 * testsPassed / totalTests + "%");
    }
}

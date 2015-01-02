package com.torstling.bychanuser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Make sure that we can use Bychan even though Jetbrains annotations
 * are not on the classpath
 */
public class UserTest {

    @Test(expected = ClassNotFoundException.class)
    public void intellijAnnotationsAreNotOnClasspath() throws ClassNotFoundException {
        ClassLoader.getSystemClassLoader().loadClass("org.jetbrains.annotations.NotNull");
    }

    @Test
    public void calculates() {
        assertEquals((Integer) 10, new User().calculate("3+5+2"));
    }
}

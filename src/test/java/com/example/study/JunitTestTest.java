package com.example.study;

import org.junit.*;

import static org.junit.Assert.*;

public class JunitTestTest {
    public static JunitTest junitTest;

    @BeforeClass
    public static void makeInstance() throws Exception {
        junitTest = new JunitTest("송지은", 24, 164.0f);
    }

    @Before
    public void beforeTest() throws Exception {
        System.out.println("before");
    }

    @Test
    public void getName() throws Exception {
        assertEquals("송지은", junitTest.getName());
    }

    @Test
    public void getAge() throws Exception {
        assertEquals(24, junitTest.getAge());
    }

    @Test
    public void getTall() throws Exception {
        assertEquals(164.0f, junitTest.getTall());
    }

    @Test
    public void setAge() throws Exception {
        junitTest.setAge(20);
    }

    @Test
    public void getAge2() throws Exception {
        assertEquals(24, junitTest.getAge());
    }

    @Test
    @Ignore
    public void setTall() throws Exception {
        junitTest.setTall(168.0f);
    }

    @Test
    public void getTall2() throws Exception {
        assertEquals(168.0f, junitTest.getTall());
    }

    @Test
    public void setName() throws Exception {
        assertEquals("지은", junitTest.getName());
    }

    @Test
    public void getName2() throws Exception {
        assertEquals("송지은", junitTest.getName());
    }

    @After
    public void printAfter() throws Exception {
        System.out.println("After");
    }

    @AfterClass
    public static void printAfterClass() throws Exception {
        System.out.println("AFTER CLASS");
    }
}
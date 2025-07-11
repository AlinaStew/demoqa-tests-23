package tests;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("###     beforeAll()\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("###     beforeEach()");
        result = 3;
    }

    @AfterEach
    void afterEach(){
        System.out.println("###     afterEach()\n");
        result = 0;
    }

    @Test
    void firstTest() {
        System.out.println("###     firstTest()");
        Assertions.assertTrue(result  > 2);
    }

    @Test
    void secondTest() {
        System.out.println("###     secondTest()");
        Assertions.assertTrue(result  > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("###     thirdTest()");
        Assertions.assertTrue(result > 2);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("###     afterAll()\n");
    }
}

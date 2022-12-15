package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    @DisplayName("Test Proper View name is returned for index page")
    void index() {
        // normal use, standart case
        assertEquals("index", controller.index());
        // use it for extra information case
        assertEquals("index", controller.index(),"Wrong view return");
        // expensive way for extra information case
        assertEquals("index", controller.index(),() -> "This is some expensive " +
                "Message to build " +
                "for my test");
    }

    @Test
    @DisplayName("Test Exception")
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> controller.oopsHandler());
    }

    @Disabled("Demo of Timeout")
    @Test
    void testTimeOut() {
        assertTimeout(
                Duration.ofMillis(100), () -> {
                    Thread.sleep(5000);
                    System.out.println("I got here");
        });
    }

    @Disabled("Demo of Timeout")
    @Test
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got here now");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueWhenTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }



}
package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void oupsHandler() {
        assertEquals("notimplemented", controller.oupsHandler(), "This is some expensive " +
                "Message to build " +
                "for my test");
    }
}
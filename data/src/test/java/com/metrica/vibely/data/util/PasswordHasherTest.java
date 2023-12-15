package com.metrica.vibely.data.util;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordHasherTest {

    // <<-CONSTANT->>
    private static final String PASSWORD = "password";

    @Test
    void differentHashesTest() {
        String hashedPassword1 = PasswordHasher.hash(PASSWORD);
        String hashedPassword2 = PasswordHasher.hash(PASSWORD);

        assertNotEquals(hashedPassword1, hashedPassword2);
    }

    @Test
    void matchesTest() {
        String hashedPassword1 = PasswordHasher.hash(PASSWORD);
        String hashedPassword2 = PasswordHasher.hash(PASSWORD);

        assertTrue(PasswordHasher.matches(PASSWORD, hashedPassword1));
        assertTrue(PasswordHasher.matches(PASSWORD, hashedPassword2));
    }

    @RepeatedTest(5)
    void oneWayHashingTest() {
        String firstTime  = PasswordHasher.hash(PASSWORD);
        String secondTime = PasswordHasher.hash(firstTime);

        assertNotEquals(PASSWORD, secondTime);
    }
}

package ru.alena.todoapp.todoapp;

import org.junit.jupiter.api.*;

import static ru.alena.todoapp.todoapp.Utils.*;

public class UtilsTest {


    @Test
    public void isUsernameCorrectTest() {
        Assertions.assertTrue(isUsernameCorrect("user1"));
        Assertions.assertFalse(isUsernameCorrect(""));
        Assertions.assertFalse(isUsernameCorrect(null));
        Assertions.assertTrue(isUsernameCorrect("0123456789!@#$%^&*()/\\|~\",:;."));
        Assertions.assertFalse(isUsernameCorrect("useruseruseruseruseruseruseruseruseruseruseruseruseruseruseruseruser"));
        Assertions.assertFalse(isUsernameCorrect("use"));
    }

    @Test
    public void isEmailCorrectTest() {
        Assertions.assertTrue(isEmailCorrect("user@mail.com"));
        Assertions.assertFalse(isEmailCorrect("usermail.com"));
        Assertions.assertFalse(isEmailCorrect("user@mailcom"));
        Assertions.assertFalse(isEmailCorrect("user"));
    }

    @Test
    public void isPasswordCorrectTest() {
        Assertions.assertTrue(isPasswordCorrect("password"));
        Assertions.assertFalse(isPasswordCorrect("pass"));
        Assertions.assertFalse(isPasswordCorrect("passwordpassword"));
    }


    @Test
    public void isStringUUIDTest() {
        Assertions.assertTrue(isStringUUID("6a8faa92-8b71-4047-b325-7c5ff84adddd"));
        Assertions.assertFalse(isStringUUID("6a8faa92-8b71-4047-b325"));
        Assertions.assertFalse(isStringUUID("6a8faa92"));

    }

}

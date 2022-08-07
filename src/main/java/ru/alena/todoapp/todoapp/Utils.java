package ru.alena.todoapp.todoapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Pattern;

public class Utils {

    public static String encryptPassword(String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.encode(password);
    }

    public static boolean isUsernameCorrect(String username) {
        if (username == null) return false;
        return 4 <= username.length() && username.length() <= 64;
    }

    public static boolean isPasswordCorrect(String password) {
        if (password == null) return false;
        return 8 <= password.length() && password.length() <= 15;
    }

    public static boolean isEmailCorrect(String email) {
        return Pattern.compile(
                        "(^[a-zA-Z0-9]{1,75}+)" +
                                "(@)" +
                                "([a-zA-Z0-9]{1,75}+)" +
                                "\\." +
                                "([a-zA-Z0-9]{1,75}+)$")
                .matcher(email)
                .matches();
    }

    public static boolean isColumnExist(String columName) {
        if (columName != null) {
            return switch (columName) {
                case "username", "password", "email" -> true;
                default -> false;
            };
        } else return false;
    }


}

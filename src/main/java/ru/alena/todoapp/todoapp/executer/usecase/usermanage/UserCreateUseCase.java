package ru.alena.todoapp.todoapp.executer.usecase.usermanage;


import org.springframework.stereotype.Service;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.entityes.User;
import ru.alena.todoapp.todoapp.executer.dataproviders.database.repositories.UserRepository;
import ru.alena.todoapp.todoapp.executer.entrypoints.http.requests.RequestCreateUser;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserCreateUseCase {

    private final UserRepository userRepository;

    public UserCreateUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(RequestCreateUser request) {
        User newUser = User.builder()
                .username(request.getUsername())
                .cryptoPassword(encryptPassword(request.getPassword()))
                .email(request.getEmail())
                .build();
        return userRepository.save(newUser);
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashedPassword = no.toString(16);
            while (hashedPassword.length() < 32) {
                hashedPassword = "0" + hashedPassword;
            }
            return hashedPassword;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

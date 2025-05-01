package com.example.copsboot.user;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private static UserRepository repository = null;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findUserByAuthServerId(AuthServerId authServerId) {
        return repository.findByAuthServerId(authServerId).toJavaUtil();
    }

    public static User createUser(CreateUserParameters createUserParameters) {
        UserId userId = repository.nextId();
        User user = new User(userId,
                createUserParameters.email(),
                createUserParameters.authServerId(),
                createUserParameters.mobileToken());
        return repository.save(user);
    }

    public User getUserById(UserId reporterId) {
        return repository.findById(reporterId)
                .orElseThrow(() -> new UserNotFoundException(reporterId));
    }
}


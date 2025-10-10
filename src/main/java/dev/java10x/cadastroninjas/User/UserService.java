package dev.java10x.cadastroninjas.User;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }
}

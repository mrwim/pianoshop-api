package nl.inholland.pianoshopapi.service;

import nl.inholland.pianoshopapi.model.User;
import nl.inholland.pianoshopapi.model.dto.LoginRequestDTO;
import nl.inholland.pianoshopapi.model.dto.LoginResponseDTO;
import nl.inholland.pianoshopapi.repository.UserRepository;
import nl.inholland.pianoshopapi.security.JwtProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private JwtProvider jwtProvider;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public User createUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("Username is already taken");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequest) throws AuthenticationException {
        User user = userRepository.findByUsername(loginRequest.username());
        if (user != null && passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            return new LoginResponseDTO(user.getUsername(), jwtProvider.createToken(user.getUsername(), user.getRoles()));
        } else {
            throw new AuthenticationException("Invalid credentials");
        }
    }
}
package tn.esprit.backend.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.backend.repository.UserRepository;
import tn.esprit.backend.model.classes.User;
import tn.esprit.backend.service.ServiceInterface.UserServiceInt;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInt {

    @Autowired
    private UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Method to get all users
    @Override
    public List<User> retreiveAllUsers() {
        return userRepo.findAll();
    }

    //Method to get user by id
    @Override
    public User retreiveUser(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    //Method to get user by username
    @Override
    public User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }

    //Method to register(add) user to DB
    @Override
    public void register(User user) {
        if (userRepo.findUserByUsername(user.getUsername()) == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
        }
    }

    //Method to update user email if the user already exists
    @Override
    public void updateUserProfile(String username, User updatedUser) {
        User existingUser = userRepo.findUserByUsername(username);
        if (existingUser != null) {
            existingUser.setEmail(updatedUser.getEmail());
            // update other fields as necessary
            userRepo.save(existingUser);
        }
    }


}

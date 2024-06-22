package tn.esprit.backend.service.ServiceInterface;

import tn.esprit.backend.model.classes.User;

import java.util.List;

public interface UserServiceInt {

    List<User> retreiveAllUsers();
    User retreiveUser(Long userId);
    User findUserByUsername(String username);
    void register(User user);
    void updateUserProfile(String username, User updatedUser);

}

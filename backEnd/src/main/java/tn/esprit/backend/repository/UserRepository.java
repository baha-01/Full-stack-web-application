package tn.esprit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backend.model.classes.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}

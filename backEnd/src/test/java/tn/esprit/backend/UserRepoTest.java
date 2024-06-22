//package tn.esprit.backend;
//import static org.assertj.core.api.Assertions.assertThat;
//import static tn.esprit.backend.model.enums.Role.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//import tn.esprit.backend.Repository.UserRepository;
//import tn.esprit.backend.model.classes.User;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
//public class UserRepoTest {
//    @Autowired
//    private TestEntityManager entityManager;
//    @Autowired
//    private UserRepository userRepo;
//
//    @Test
//    public void testCreateUser(){
//        User user = new User();
//        user.setEmail("baaaha@gmail.com");
//        user.setPassword("01010101");
//        user.setUsername("baha");
//        user.setRole(ADMIN);
//
//        User savedUser = userRepo.save(user);
//        User existUser = entityManager.find(User.class, savedUser.getUserId());
//
//        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
//
//
//    }
//
//}

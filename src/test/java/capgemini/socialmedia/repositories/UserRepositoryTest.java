package capgemini.socialmedia.repositories;

import capgemini.socialmedia.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @Commit
    void findById_productExist_success() {
        User user = new User();

        user.setUserName("NVV");
        user.setFirstName("Nathan");
        user.setLastName("Van Velden");
        user.setAge(20);

        userRepository.save(user);
        assertTrue(user.getId() > 0);

        User user2 = userRepository.findById(user.getId()).orElseThrow();
        assertNotNull(user2);

        assertEquals(user.getFirstName(), user2.getFirstName());
    }
}
package capgemini.socialmedia.repositories;

import capgemini.socialmedia.models.User;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

import java.util.Optional;

public interface UserRepository extends KeyValueRepository<User, Integer> {

    Optional<User> findByFirstName(String firstName);

    Optional<User> findByLastName(String lastName);

    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<User> findByAge(int age);
}

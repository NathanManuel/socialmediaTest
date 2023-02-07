package capgemini.socialmedia.repositories;

import capgemini.socialmedia.models.Post;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

import java.util.Optional;

public interface PostRepository extends KeyValueRepository<Post, Integer> {

    Optional<Post> findByDescription(String description);

}

package capgemini.socialmedia.repositories;

import capgemini.socialmedia.models.Comment;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

import java.util.Optional;

public interface CommentRepository extends KeyValueRepository<Comment, Integer> {

    Optional<Comment> findByDescription(String description);

    Optional<Comment> findByParent_id(int parent_id);

    Optional<Comment> findByUserLikes(int user_likes);
}

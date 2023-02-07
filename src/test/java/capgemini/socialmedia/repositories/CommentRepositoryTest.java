package capgemini.socialmedia.repositories;

import capgemini.socialmedia.models.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    //Test Comment Repository
    @Autowired
    CommentRepository commentRepository;

    @Test
    @Commit
    void findById_productExist_success() {

        Comment comment = new Comment();
        commentRepository.save(comment);
        assertTrue(comment.getId() > 0);

        Comment comment2 = commentRepository.findById(comment.getId()).orElseThrow();
        assertNotNull(comment2);

        assertEquals(comment.getDescription(), comment2.getDescription());
    }

}
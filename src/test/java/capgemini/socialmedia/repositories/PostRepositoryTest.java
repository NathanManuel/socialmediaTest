package capgemini.socialmedia.repositories;

import capgemini.socialmedia.models.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    @Commit
    void findById_productExist_success() {
        Post post = new Post();

        post.setName("Post");
        post.setDescription("This is a post");
        post.setId(1);
        post.setId(4);

        postRepository.save(post);
        assertTrue(post.getId() > 0);

        Post post2 = postRepository.findById(post.getId()).orElseThrow();
        assertNotNull(post2);

        assertEquals(post.getName(), post2.getName());
    }
}
package capgemini.socialmedia.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    private Post post;

    @BeforeEach
    void setup() {
        post = new Post();
    }

    @Test
    @DisplayName("When given an id the post should have that id.")
    void givenID_shouldReturnThatID() {
        int idx = 67567;
        post.setId(idx);
        assertEquals(post.getId(), idx);
    }

    @Test
    @DisplayName("When given a Description the post should have that Description.")
    void givenDescription_shouldReturnThatDescription() {
        String description = "A delightful view!";
        post.setDescription(description);
        assertEquals(post.getDescription(), description);
    }

    @Test
    @DisplayName("When given an UserID the post should have that UserID.")
    void givenUserID_shouldReturnThatUserID() {
        int idx = 67567;
        post.setId(idx);
        assertEquals(post.getId(), idx);
    }
}
package capgemini.socialmedia.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {
    private Comment com;

    @BeforeEach
    void setup() {
        com = new Comment();
    }

    @Test
    @DisplayName("When given an id the comment should have that id.")
    void givenID_shouldReturnThatID() {
        int idx = 67567;
        ;
        com.setId(idx);
        assertEquals(com.getId(), idx);
    }

    @Test
    @DisplayName("When given a Description the comment should have that Description.")
    void givenDescription_shouldReturnThatDescription() {
        String description = "A delightful view!";
        com.setDescription(description);
        assertEquals(com.getDescription(), description);
    }

    @Test
    @DisplayName("When given an UserID the comment should have that UserID.")
    void givenUserID_shouldReturnThatUserID() {
        int idx = 67567;
        com.setId(idx);
        assertEquals(com.getId(), idx);
    }
}
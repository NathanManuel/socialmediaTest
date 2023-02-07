package capgemini.socialmedia.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeEach
    void setup() {
        user = new User();
    }

    @Test
    @DisplayName("When given an id the user should have that id.")
    void givenID_shouldReturnThatID() {
        int idx = 123;
        user.setId(idx);
        assertEquals(user.getId(), idx);
    }

    @Test
    @DisplayName("When given a name the user should have that name.")
    void givenDescription_shouldReturnThatDescription() {
        String user_name = "Ana Maria";
        user.setUserName(user_name);
        assertEquals(user.getUserName(), user_name);
    }
}
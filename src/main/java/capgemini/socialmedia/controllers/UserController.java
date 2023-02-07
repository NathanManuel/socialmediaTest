package capgemini.socialmedia.controllers;

import capgemini.socialmedia.models.Comment;
import capgemini.socialmedia.models.User;
import capgemini.socialmedia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@Valid @RequestBody User user) {


        User user2 = userService.select(1);
        user.setCreatedBy(user2);
        user.setLastModifiedBy(user2);

        userService.add(user);
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAll();
        /*
            Test
        List<Person> l = new ArrayList<>();
        l.add(new Person(UUID.randomUUID(),"Ana"));
        l.add(new Person(UUID.randomUUID(),"Andrei"));
        l.add(new Person(UUID.randomUUID(),"Matei"));
        return l;*/
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        User u = userService.select(id);
        if (u == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(u);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") int id) {
        User u = userService.delete(id);

        if (u == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(u);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") int id, @Valid @RequestBody User user) {

        User user2 = userService.select(1);

        user.setLastModifiedBy(user2);

        User u = userService.update(id, user);

        if (u == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(u);
    }

}

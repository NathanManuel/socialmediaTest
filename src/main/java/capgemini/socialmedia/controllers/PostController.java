package capgemini.socialmedia.controllers;

import capgemini.socialmedia.models.Post;
import capgemini.socialmedia.models.User;
import capgemini.socialmedia.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RequestMapping("api/v1/posts")
@RestController
public class PostController {

    private final PostService postService;


    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public void addPost(@Valid @RequestBody Post post) {

        User tempUser = new User();
        tempUser.setFirstName("Admin");
        tempUser.setLastName("admin");
        tempUser.setUserName("Admin");
        tempUser.setAge(20);

        post.setCreatedBy(tempUser);
        post.setLastModifiedBy(tempUser);

        postService.add(post);
    }

    @GetMapping
    public Iterable<Post> getAllPosts() {
        return postService.getAll();
        /*
            Test
        List<Person> l = new ArrayList<>();
        l.add(new Person(UUID.randomUUID(),"Ana"));
        l.add(new Person(UUID.randomUUID(),"Andrei"));
        l.add(new Person(UUID.randomUUID(),"Matei"));
        return l;*/
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") int id) {
        Post p = postService.select(id);

        if (p == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(p);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Post> deletePostById(@PathVariable("id") int id) {
        Post p = postService.delete(id);

        if (p == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(p);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Post> updatePostById(@PathVariable("id") int id, @Valid @RequestBody Post post) {

//        LocalDateTime date = LocalDateTime.now();
//        post.setLastModifiedAt(date);

        User tempUser = new User();
        tempUser.setId(1);
        tempUser.setFirstName("Admin");
        tempUser.setLastName("admin");
        tempUser.setUserName("Admin");
        tempUser.setAge(20);

        post.setLastModifiedBy(tempUser);

        Post p = postService.update(id, post);

        if (p == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(p);
    }

}

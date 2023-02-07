package capgemini.socialmedia.controllers;

import capgemini.socialmedia.models.Comment;
import capgemini.socialmedia.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("api/v1/comments")
@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public void addUser(@Valid @RequestBody Comment com) {
        commentService.add(com);
    }

    @GetMapping
    public Iterable<Comment> getAllUsers() {
        return commentService.getAll();
        /*
            Test
        List<Person> l = new ArrayList<>();
        l.add(new Person(UUID.randomUUID(),"Ana"));
        l.add(new Person(UUID.randomUUID(),"Andrei"));
        l.add(new Person(UUID.randomUUID(),"Matei"));
        return l;*/
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") int id) {
        Comment c = commentService.select(id);

        if (c == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(c);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Comment> deleteCommentById(@PathVariable("id") int id) {
        Comment c = commentService.delete(id);

        if (c == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(c);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Comment> updateCommentById(@PathVariable("id") int id, @Valid @RequestBody Comment com) {
        Comment c = commentService.update(id, com);

        if (c == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(c);
    }
}

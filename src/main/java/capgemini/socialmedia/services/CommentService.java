package capgemini.socialmedia.services;

import capgemini.socialmedia.models.Comment;
import capgemini.socialmedia.models.Post;
import capgemini.socialmedia.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository repo;
    private int last_id;

    public CommentService(CommentRepository repo) {
        this.repo = repo;
        last_id = 1;
        Iterable<Comment> it = repo.findAll();
        if (it != null)
            it.forEach(x -> last_id = x.getId() + 1);
    }

    public void add(Comment com) {
        repo.save(com);
    }

    public Comment delete(int id) {
        Optional<Comment> c = repo.findById(id);

        if (c.isEmpty())
            return null;

        repo.deleteById(id);
        return c.get();
    }

    public Comment update(int id, Comment new_com) {
        Optional<Comment> c = repo.findById(id);

        if (c.isEmpty())
            return null;

        new_com.setId(id);
        repo.save(new_com);
        return c.get();
    }

    public Iterable<Comment> getAll() {
        return repo.findAll();
    }

    public Comment select(int id) {
        Optional<Comment> c = repo.findById(id);

        if (c.isEmpty())
            return null;

        return c.get();
    }
}

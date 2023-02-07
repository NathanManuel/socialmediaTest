package capgemini.socialmedia.services;

import capgemini.socialmedia.models.Post;
import capgemini.socialmedia.models.User;
import capgemini.socialmedia.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository repo;
    private int last_id;

    public PostService(PostRepository repo) {
        this.repo = repo;
        last_id = 1;
        Iterable<Post> it = repo.findAll();
        if (it != null)
            it.forEach(x -> last_id = x.getId() + 1);
    }

    public void add(Post post) {
        repo.save(post);
    }

    public Post delete(int id) {
        Optional<Post> p = repo.findById(id);

        if (p.isEmpty())
            return null;

        repo.deleteById(id);
        return p.get();
    }

    public Post update(int id, Post new_post) {
        Optional<Post> p = repo.findById(id);

        if (p.isEmpty())
            return null;

        new_post.setId(id);
        repo.save(new_post);
        return p.get();
    }

    public Iterable<Post> getAll() {
        return repo.findAll();
    }

    public Post select(int id) {
        Optional<Post> p = repo.findById(id);

        if (p.isEmpty())
            return null;

        return p.get();
    }
}

package capgemini.socialmedia.services;

import capgemini.socialmedia.models.User;
import capgemini.socialmedia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;
    private int last_id;

    public UserService(UserRepository repo) {
        this.repo = repo;
        last_id = 1;
        Iterable<User> it = repo.findAll();
        if (it != null)
            it.forEach(x -> last_id = x.getId() + 1);
    }

    public void add(User user) {
        user.setId(last_id);
        last_id++;
        repo.save(user);
    }

    public User delete(int id) {
        Optional<User> u = repo.findById(id);

        if (u.isEmpty())
            return null;

        repo.deleteById(id);
        return u.get();
    }

    public User update(int id, User new_user) {

        Optional<User> u = repo.findById(id);

        if (u.isEmpty())
            return null;

        new_user.setId(id);
        repo.save(new_user);
        return u.get();
    }

    public Iterable<User> getAll() {
        return repo.findAll();
    }

    public User select(int id) {
        Optional<User> u = repo.findById(id);

        if (u.isEmpty())
            return null;

        return u.get();
    }

}

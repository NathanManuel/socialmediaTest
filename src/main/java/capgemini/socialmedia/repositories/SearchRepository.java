package capgemini.socialmedia.repositories;

import capgemini.socialmedia.models.Search;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

import java.util.Optional;

public interface SearchRepository extends KeyValueRepository<Search, Integer> {

    Optional<Search> findByName(String name);
}

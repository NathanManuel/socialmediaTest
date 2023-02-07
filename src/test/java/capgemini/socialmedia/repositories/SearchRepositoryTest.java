package capgemini.socialmedia.repositories;

import capgemini.socialmedia.models.Search;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SearchRepositoryTest {

    @Autowired
    SearchRepository searchRepository;

    @Test
    @Commit
    void findById_productExist_success() {
        Search search = new Search();

        search.setName("Nathan");

        searchRepository.save(search);
        assertTrue(search.getId() > 0);

        Search search2 = searchRepository.findById(search.getId()).orElseThrow();
        assertNotNull(search2);

        assertEquals(search.getName(), search2.getName());
    }
}
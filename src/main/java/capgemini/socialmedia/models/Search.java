package capgemini.socialmedia.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@RedisHash("api/v1/search")
public class Search {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

}

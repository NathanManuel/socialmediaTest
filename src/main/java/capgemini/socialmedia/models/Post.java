package capgemini.socialmedia.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@RedisHash("api/v1/posts")
public class Post extends BaseEntity {

    @Size(min = 0, max = 3000)
    protected String description;
    @NotNull
    @PositiveOrZero
    protected int idUser;
    @NotNull
    @Size(min = 1, max = 100)
    private String name;
}

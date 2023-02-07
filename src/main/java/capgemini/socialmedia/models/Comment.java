package capgemini.socialmedia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@RedisHash("api/v1/comments")
public class Comment extends BaseEntity {

    @Size(min = 0, max = 3000)
    private String description;

    @NotNull
    @PositiveOrZero
    private int parentId;

    @NotNull
    @PositiveOrZero
    private int userLikes;
}
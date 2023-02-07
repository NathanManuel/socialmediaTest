package capgemini.socialmedia.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @PositiveOrZero
    private int id;

    private LocalDateTime createdAt;

    private User createdBy;

    private LocalDateTime lastModifiedAt;

    private User lastModifiedBy;

    protected BaseEntity() {
        createdAt = LocalDateTime.now();
        lastModifiedAt = LocalDateTime.now();
    }
}

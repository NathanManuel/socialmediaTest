package capgemini.socialmedia.repositories;

import capgemini.socialmedia.models.BaseEntity;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface BaseEntityRepository extends KeyValueRepository<BaseEntity, Integer> {

//    @Override
//    default <S extends T> S save(S entity){
//        return super.save(entity);
//    }
}

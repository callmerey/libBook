package lib_book.lib.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lib_book.lib.models.Mob;



@Repository
public interface MobRepository extends CrudRepository<Mob, Integer> {
    List<Mob> findByNameLikeOrderByIdAsc(String name);

    List<Mob> findByNameLikeOrderByIdDesc(String name);

    List<Mob> findByNameLikeOrderByLevelAsc(String name);

    List<Mob> findByNameLikeOrderByLevelDesc(String name);
}

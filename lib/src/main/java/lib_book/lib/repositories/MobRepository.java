package lib_book.lib.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lib_book.lib.models.Mob;



@Repository
public interface MobRepository extends CrudRepository<Mob, Integer> {
    List<Mob> findByNameLike(String name);
}

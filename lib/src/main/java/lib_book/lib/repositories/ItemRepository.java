package lib_book.lib.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lib_book.lib.models.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer>{

    @Query(value    =   "SELECT * FROM items "
                    +   " where category_id = ?1 and name like ?2 order by id asc"
    ,nativeQuery = true)
    List<Item> findByTypeAndNameLike(Integer typeId, String name);


    @Query(value    =   "SELECT * FROM items "
                    +   " where category_id = ?1 order by id asc"
    ,nativeQuery = true)
    List<Item> findByType(Integer typeId);


    List<Item> findByNameLike(String name);
}

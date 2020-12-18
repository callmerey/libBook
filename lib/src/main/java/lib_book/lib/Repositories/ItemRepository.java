package lib_book.lib.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lib_book.lib.models.Item;


@Repository
public interface ItemRepository extends CrudRepository<Item, Integer>{
    // @Query(value    =   "SELECT * FROM lovems1.lib_items i"
    //                 +   " where i.id >= ?1 and i.id < ?2 and i.name like %?3"
    //                 +   " group by i.id asc"
    //                 +   " limit ?4 , ?5"
    // ,nativeQuery = true)
    // List<Item> findByIdRange(Integer min, Integer max, String name, long firstObject, long limit);
}

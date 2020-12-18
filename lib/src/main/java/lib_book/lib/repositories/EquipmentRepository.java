package lib_book.lib.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lib_book.lib.models.Equipment;



@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Integer>{

    // @Query(value    =   "SELECT * FROM lovems1.lib_equipments e"
    //                 +   " inner join lovems1.lib_items i"
    //                 +   " on e.id = i.id"
    //                 +   " where e.id >= ?1 and e.id < ?2 and i.name like %?3"
    //                 +   " group by e.id asc"
    //                 +   " limit ?4 , ?5"
    // ,nativeQuery = true)
    // List<Equipment> findByIdRange(Integer min, Integer max, String name, long firstObject, long limit);

}

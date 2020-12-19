package lib_book.lib.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lib_book.lib.models.Equipment;



@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Integer>{

    @Query(value    =   "SELECT * FROM equipments "
                    +   "where category_id = ?1 and name like ?2"
    ,nativeQuery = true)
    List<Equipment> findByTypeAndNameLike(Integer typeId, String name);

    
    List<Equipment> findByNameLike(String name);


    @Query(value    =   "SELECT * FROM equipments "
    +   "where category_id >= ?1 and category_id <= ?2"
    ,nativeQuery = true)
    List<Equipment> findByWeapon(Integer begin , Integer end);

}

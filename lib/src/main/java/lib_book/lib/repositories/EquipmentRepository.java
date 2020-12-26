package lib_book.lib.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lib_book.lib.models.Equipment;



@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Integer>{

    @Query(value    =   "SELECT * FROM equipments "
    +   "where category_id >= ?1 and category_id <= ?2 and name like ?3 order by id asc"
    ,nativeQuery = true)
    List<Equipment> findByNameLike(Integer begin , Integer end, String name);

    @Query(value    =   "SELECT * FROM equipments "
    +   "where category_id >= ?1 and category_id <= ?2 and name like ?3 and cash = ?4 order by id asc"
    ,nativeQuery = true)
    List<Equipment> findByCashAndNameLike(Integer begin , Integer end, String name, Integer cash);

    @Query(value    =   "SELECT * FROM equipments "
    +   "where category_id >= ?1 and category_id <= ?2 and name like ?3 and category_id = ?4 order by id asc"
    ,nativeQuery = true)
    List<Equipment> findByTypeAndNameLike(Integer begin , Integer end, String name, Integer typeId);

    @Query(value    =   "SELECT * FROM equipments "
    +   "where category_id >= ?1 and category_id <= ?2 and name like ?3 and category_id = ?4 and cash = ?5 order by id asc"
    ,nativeQuery = true)
    List<Equipment> findByTypeAndCashAndNameLike(Integer begin , Integer end, String name, Integer typeId, Integer cash);
}

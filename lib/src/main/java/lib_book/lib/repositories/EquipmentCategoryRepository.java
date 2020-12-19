package lib_book.lib.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lib_book.lib.models.EquipmentCategory;

@Repository
public interface EquipmentCategoryRepository extends CrudRepository<EquipmentCategory, Integer>{

    @Query(value    =   "SELECT * FROM equipment_categories "
    +   "where id >= ?1 and id <= ?2"
    ,nativeQuery = true)
    List<EquipmentCategory> findByEquipmentCategorie(Integer begin , Integer end);
}

package lib_book.lib.services;

import java.util.List;

import lib_book.lib.models.EquipmentCategory;

public interface EquipmentCategoryService {
    
    public EquipmentCategory findById(Integer id) throws Exception;

    public List<EquipmentCategory> findAll();

    public List<EquipmentCategory> findAllById(Iterable<Integer> ids);

    List<EquipmentCategory> findByEquipmentCategorie(Integer begin , Integer end);
}

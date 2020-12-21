package lib_book.lib.services;

import java.util.List;

import lib_book.lib.models.Equipment;

public interface EquipmentService {
    
    public List<Equipment> findAll();

    public List<Equipment> findAllById(List<Integer> ids);

    public Equipment findById(Integer id) throws Exception;

    public List<Equipment> findByNameLike(Integer begin, Integer end, String name);

    public List<Equipment> findByTypeAndNameLike(Integer begin, Integer end, String name, Integer typeId);

}

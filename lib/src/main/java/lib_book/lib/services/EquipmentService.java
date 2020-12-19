package lib_book.lib.services;

import java.util.List;

import lib_book.lib.models.Equipment;

public interface EquipmentService {
    
    public List<Equipment> findAll();

    public List<Equipment> findAllById(List<Integer> ids);

    public Equipment findById(Integer id) throws Exception;

    public List<Equipment> findByNameLike(String name);

    List<Equipment> findByTypeAndNameLike(Integer typeId, String name);

    List<Equipment> findByWeapon(Integer begin , Integer end);
}

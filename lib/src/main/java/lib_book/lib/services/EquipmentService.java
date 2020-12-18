package lib_book.lib.services;

import java.util.List;

import lib_book.lib.models.Equipment;

public interface EquipmentService {
    
    public List<Equipment> findAll();

    public List<Equipment> findAllById(List<Integer> ids);

    public Equipment findById(Integer id) throws Exception;

}

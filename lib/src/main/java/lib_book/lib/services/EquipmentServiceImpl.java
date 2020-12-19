package lib_book.lib.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib_book.lib.models.Equipment;
import lib_book.lib.repositories.EquipmentRepository;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> findAll() {
        return (List<Equipment>)equipmentRepository.findAll();
    }

    @Override
    public List<Equipment> findAllById(List<Integer> ids) {
        return (List<Equipment>) equipmentRepository.findAllById(ids);

    }

    @Override
    public Equipment findById(Integer id) throws Exception{
        Equipment e = new Equipment();

        //Find Equipment
        Optional<Equipment> opts = equipmentRepository.findById(id);

        if(opts.isPresent()){
            e = opts.get();
        }else{
            throw new Exception("Equiment not found");
        }

        return e;
    }    

    @Override
    public List<Equipment> findByNameLike(String name) {
        return equipmentRepository.findByNameLike("%" + name + "%");
    }

    @Override
    public List<Equipment> findByTypeAndNameLike(Integer typeId, String name){
        return equipmentRepository.findByTypeAndNameLike(typeId ,"%" + name + "%");
    }

    @Override
    public List<Equipment> findByWeapon(Integer begin , Integer end){
        return equipmentRepository.findByWeapon(begin,end);
    }

}

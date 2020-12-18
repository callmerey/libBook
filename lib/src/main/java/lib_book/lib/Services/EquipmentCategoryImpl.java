package lib_book.lib.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib_book.lib.Repositories.EquipmentCategoryRepository;
import lib_book.lib.models.EquipmentCategory;

@Service
public class EquipmentCategoryImpl implements EquipmentCategoryService {

    @Autowired
    private EquipmentCategoryRepository equipmentCategoryRepository;

    @Override
    public EquipmentCategory findById(Integer id) throws Exception {
        EquipmentCategory eC = new EquipmentCategory();

        //Find EquipmentCategory
        Optional<EquipmentCategory> opts = equipmentCategoryRepository.findById(id);

        if(opts.isPresent()){
            eC = opts.get();
        }else{
            throw new Exception("EquimentCategory not found");
        }

        return eC;
    }

    @Override
    public List<EquipmentCategory> findAll() {
        return (List<EquipmentCategory>) equipmentCategoryRepository.findAll();
    }

    @Override
    public List<EquipmentCategory> findAllById(Iterable<Integer> ids) {
        return (List<EquipmentCategory>) equipmentCategoryRepository.findAllById(ids);
    }

    
}

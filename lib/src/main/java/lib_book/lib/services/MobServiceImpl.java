package lib_book.lib.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib_book.lib.models.Mob;
import lib_book.lib.repositories.MobRepository;

@Service
public class MobServiceImpl implements MobService{

    @Autowired
    private MobRepository mobRepository;

    @Override
    public List<Mob> findByNameLike(String name, String order, String type) {
        if (order.equalsIgnoreCase("id")) {
            if (type.equalsIgnoreCase("asc")) {
                return mobRepository.findByNameLikeOrderByIdAsc("%" + name + "%");
            }
            if (type.equalsIgnoreCase("desc")) {
                return mobRepository.findByNameLikeOrderByIdDesc("%" + name + "%");
            }
        }
        if (order.equalsIgnoreCase("level")) {
            if (type.equalsIgnoreCase("asc")) {
                return mobRepository.findByNameLikeOrderByLevelAsc("%" + name + "%");
            }
            if (type.equalsIgnoreCase("desc")) {
                return mobRepository.findByNameLikeOrderByLevelDesc("%" + name + "%");
            }
        }
        return null;
    }

    @Override
    public Mob findById(Integer id) throws Exception{
        Mob m = new Mob();

        //Find Equipment
        Optional<Mob> opts = mobRepository.findById(id);

        if(opts.isPresent()){
            m = opts.get();
        }else{
            throw new Exception("Mob not found");
        }

        return m;
    }    
}

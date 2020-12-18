package lib_book.lib.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib_book.lib.models.Mob;
import lib_book.lib.repositories.MobRepository;

@Service
public class MobServiceImpl implements MobService {

    @Autowired
    private MobRepository mobRepository;

    @Override
    public List<Mob> findByNameLike(String name) {
        return mobRepository.findByNameLike("%" + name + "%");
    }

}

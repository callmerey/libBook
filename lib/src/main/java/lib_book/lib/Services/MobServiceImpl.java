package lib_book.lib.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib_book.lib.Repositories.MobRepository;
import lib_book.lib.models.Mob;

@Service
public class MobServiceImpl implements MobService {

    @Autowired
    private MobRepository mobRepository;

    @Override
    public List<Mob> findByName(String name) {
        return mobRepository.findByNameLike("%" + name + "%");
    }

}

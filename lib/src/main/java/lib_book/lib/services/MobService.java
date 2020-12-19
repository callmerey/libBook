package lib_book.lib.services;

import java.util.List;

import lib_book.lib.models.Mob;

public interface MobService {
    public List<Mob> findByNameLike(String name);

    public Mob findById(Integer id) throws Exception;
}

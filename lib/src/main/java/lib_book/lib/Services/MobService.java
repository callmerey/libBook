package lib_book.lib.Services;

import java.util.List;

import lib_book.lib.models.Mob;

public interface MobService {
    public List<Mob> findByName(String name);
}

package lib_book.lib.services;

import java.util.List;

import lib_book.lib.models.Item;

public interface ItemService {
    
    public Item findById(Integer id) throws Exception;

    public List<Item> findAll();

    public List<Item> findAllById(Iterable<Integer> ids);

    public List<Item> findByNameLike(String name);

    List<Item> findByTypeAndNameLike(Integer typeId, String name);

    public List<Item> findByType(Integer typeId);
}

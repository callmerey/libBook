package lib_book.lib.services;

import java.util.List;

import lib_book.lib.models.Item;

public interface ItemService {
    
    public Item findById(Integer id) throws Exception;

    public List<Item> findAll();

    public List<Item> findAllById(Iterable<Integer> ids);
}

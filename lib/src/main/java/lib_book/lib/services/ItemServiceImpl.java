package lib_book.lib.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib_book.lib.models.Item;
import lib_book.lib.repositories.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item findById(Integer id) throws Exception {
        Item i = new Item();

        //Find Item
        Optional<Item> opts = itemRepository.findById(id);

        if(opts.isPresent()){
            i = opts.get();
        }else{
            throw new Exception("Equiment not found");
        }
        return i;
    }

    @Override
    public List<Item> findAll() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public List<Item> findAllById(Iterable<Integer> ids) {
        return (List<Item>) itemRepository.findAllById(ids);
    }

    
}

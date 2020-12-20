package lib_book.lib.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib_book.lib.models.DropData;
import lib_book.lib.repositories.DropDataRepository;

@Service
public class DropDataServiceImpl implements DropDataService {

    @Autowired
    private DropDataRepository dropDataRepository;

    public List<DropData> findByDropperId(Integer dropperId) {
        List<DropData> l = dropDataRepository.findByDropperId(dropperId);
        System.out.println(l.toString());
        return l;
    }

    public List<DropData> findByItemId(Integer itemId) {
        List<DropData> l = dropDataRepository.findByItemId(itemId);
        System.out.println(l.toString());
        return l;
    }


}

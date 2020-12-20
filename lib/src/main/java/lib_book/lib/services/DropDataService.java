package lib_book.lib.services;

import java.util.List;

import lib_book.lib.models.DropData;

public interface DropDataService {
    
    public List<DropData> findByDropperId(Integer dropperId);

    public List<DropData> findByItemId(Integer itemId);
}

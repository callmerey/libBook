package lib_book.lib.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lib_book.lib.models.DropData;

@Repository
public interface DropDataRepository extends CrudRepository<DropData, Integer>{

    List<DropData> findByDropperId(Integer dropperId);

    List<DropData> findByItemId(Integer itemId);
}

package lib_book.lib.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lib_book.lib.models.ItemCategory;

@Repository
public interface ItemCategoryRepository extends CrudRepository<ItemCategory, Integer>{

}

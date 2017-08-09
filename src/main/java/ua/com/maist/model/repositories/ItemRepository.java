package ua.com.maist.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.maist.model.entity.Item;
import ua.com.maist.model.entity.ItemType;

import java.util.Set;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long> {
    Set<Item> findByItemType(ItemType type);

}

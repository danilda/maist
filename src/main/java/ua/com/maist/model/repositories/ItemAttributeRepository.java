package ua.com.maist.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.maist.model.entity.ItemAttribute;
import ua.com.maist.model.entity.ItemType;

import java.util.Set;

@Repository("itemAttributeRepository")
public interface ItemAttributeRepository extends JpaRepository<ItemAttribute, Long> {
    ItemAttribute findByName(String name);
    Set<ItemAttribute> findByItemTypes(ItemType type);
}

package ua.com.maist.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.maist.model.entity.ItemProperty;

@Repository("itemPropertyRepository")
public interface ItemPropertyRepository extends JpaRepository<ItemProperty, Long>{
}

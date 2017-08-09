package ua.com.maist.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.maist.model.entity.Item;
import ua.com.maist.model.entity.Order;
import ua.com.maist.model.entity.OrderItem;

import java.util.Set;

@Repository("orderItemRepository")
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    Set<OrderItem> findByOrder(Order order);
    Set<OrderItem> findByItem(Item item);
}

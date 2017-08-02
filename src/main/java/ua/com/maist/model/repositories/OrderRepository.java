package ua.com.maist.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.maist.model.entity.Order;

/**
 * Created by dach1016 on 02.08.2017.
 *
 */

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findByUser(int userId);
}

package ua.com.maist.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.maist.model.entity.Order;
import ua.com.maist.model.entity.User;

import java.util.Set;

/**
 * Created by dach1016 on 02.08.2017.
 */

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {
    Set<Order> findByUser(User userId);
}

package ua.com.maist.model.repositories;

import ua.com.maist.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.maist.model.entity.User;

import java.util.Set;

/**
 * Created by dach1016 on 24.07.2017.
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String role);
}

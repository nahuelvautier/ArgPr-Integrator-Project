package com.portfolio.nahuelvautier.Security.Repository;

import com.portfolio.nahuelvautier.Security.Entity.Role;
import com.portfolio.nahuelvautier.Security.Enums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}

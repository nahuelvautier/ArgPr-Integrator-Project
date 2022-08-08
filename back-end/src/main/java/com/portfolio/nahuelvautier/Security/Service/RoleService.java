package com.portfolio.nahuelvautier.Security.Service;

import com.portfolio.nahuelvautier.Security.Entity.Role;
import com.portfolio.nahuelvautier.Security.Enums.RoleName;
import com.portfolio.nahuelvautier.Security.Repository.iRoleRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
    @Autowired
    iRoleRepository iroleRepository;
    
    public Optional<Role> getByRoleName(RoleName roleName) {
        return iroleRepository.findByRoleName(roleName);
    }
    
    public void save(Role role) {
        iroleRepository.save(role);
    }
}

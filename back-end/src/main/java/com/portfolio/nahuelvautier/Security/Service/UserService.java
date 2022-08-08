package com.portfolio.nahuelvautier.Security.Service;

import com.portfolio.nahuelvautier.Security.Entity.User;
import com.portfolio.nahuelvautier.Security.Repository.iUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    iUserRepository iuserRepository;
    
    public Optional<User> getByUserName(String userName) {
        return iuserRepository.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName) {
        return iuserRepository.existsByUserName(userName);
    }
    
    public boolean existsByEmail(String email) {
        return iuserRepository.existsByEmail(email);
    }
    
    public void save(User user) {
        iuserRepository.save(user);
    }
}

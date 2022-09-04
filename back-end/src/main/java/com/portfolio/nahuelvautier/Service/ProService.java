package com.portfolio.nahuelvautier.Service;

import com.portfolio.nahuelvautier.Entity.Project;
import com.portfolio.nahuelvautier.Repository.ProRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProService {
    @Autowired
    ProRepository proRepository;
    
    public List<Project> list() {
        return proRepository.findAll();
    }
    
    public Optional<Project> getOne(int id) {
        return proRepository.findById(id);
    }
    
    public Optional<Project> getByProName(String proName) {
        return proRepository.findByProName(proName);
    }
    
    public void save(Project project)  {
        proRepository.save(project);
    }
    
    public void delete(int id) {
        proRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return proRepository.existsById(id);
    }
    
    public boolean existsByProName(String proName) {
        return proRepository.existsByProName(proName);
    }
}

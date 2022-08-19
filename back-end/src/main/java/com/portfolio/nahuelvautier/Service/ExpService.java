package com.portfolio.nahuelvautier.Service;

import com.portfolio.nahuelvautier.Entity.Experience;
import com.portfolio.nahuelvautier.Repository.ExpRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExpService {
    @Autowired
    ExpRepository expRepository;
    
    public List<Experience> list() {
        return expRepository.findAll();
    }
    
    public Optional<Experience> getOne(int id){
        return expRepository.findById(id);
    }
    
    public Optional<Experience> getByExpName(String expName) {
        return expRepository.findByExpName(expName);
    }
    
    public Optional<Experience> getByExpDescription(String expDescription) {
        return expRepository.findByExpDescription(expDescription);
    }
    
    public void save(Experience experience) {
        expRepository.save(experience);
    }
    
    public void delete(int id){
        expRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return expRepository.existsById(id);
    }
    
    public boolean existsByExpName(String expName) {
        return expRepository.existsByExpName(expName);
    }
    
    public boolean existsByExpDescription(String expDescription) {
        return expRepository.existsByExpDescription(expDescription);
    }
}

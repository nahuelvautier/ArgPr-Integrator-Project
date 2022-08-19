package com.portfolio.nahuelvautier.Service;

import com.portfolio.nahuelvautier.Entity.Education;
import com.portfolio.nahuelvautier.Repository.EduRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EduService {
    @Autowired
    EduRepository eduRepository;
    
    public List<Education> list() {
        return eduRepository.findAll();
    }
    
    public Optional<Education> getOne(int id) {
        return eduRepository.findById(id);
    }
    
    public Optional<Education> getByEduName(String eduName) {
        return eduRepository.findByEduName(eduName);
    }
    
    public Optional<Education> getByEduDescription(String eduDescription) {
        return eduRepository.findByEduDescription(eduDescription);
    }
    
    public void save(Education education) {
        eduRepository.save(education);
    }
    
    public void delete(int id) {
        eduRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return eduRepository.existsById(id);
    }
    
    public boolean existsByEduName(String eduName) {
        return eduRepository.existsByEduName(eduName);
    }
    
    public boolean existsByEduDescription(String eduDescription) {
        return eduRepository.existsByEduDescription(eduDescription);
    }
}

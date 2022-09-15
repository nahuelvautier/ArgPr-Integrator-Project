package com.portfolio.nahuelvautier.Service;

import com.portfolio.nahuelvautier.Entity.HardSoftSkill;
import com.portfolio.nahuelvautier.Repository.HardSoftSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class HardSoftSkillService {
    @Autowired
    HardSoftSkillRepository hssRepository;
    
    public List<HardSoftSkill> list() {
        return hssRepository.findAll();
    }
    
    public Optional<HardSoftSkill> getOne(int id) {
        return hssRepository.findById(id);
    }
    
    public Optional<HardSoftSkill> getByHsTitle(String hsTitle) {
        return hssRepository.findByHsTitle(hsTitle);
    }
    
    public void save(HardSoftSkill hss) {
        hssRepository.save(hss);
    }
    
    public void delete(int id) {
        hssRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return hssRepository.existsById(id);
    }
    
    public boolean existsByHsTitle(String hsTitle) {
        return hssRepository.existsByHsTitle(hsTitle);
    }
}
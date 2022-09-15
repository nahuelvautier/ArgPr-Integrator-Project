package com.portfolio.nahuelvautier.Repository;

import com.portfolio.nahuelvautier.Entity.HardSoftSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSoftSkillRepository extends JpaRepository<HardSoftSkill, Integer> {
    public Optional<HardSoftSkill> findByHsTitle(String hsTitle);
    public boolean existsByHsTitle(String hsTitle);
    public boolean existsById(int id);
}
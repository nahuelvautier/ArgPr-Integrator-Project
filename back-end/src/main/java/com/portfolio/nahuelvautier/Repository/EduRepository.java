package com.portfolio.nahuelvautier.Repository;

import com.portfolio.nahuelvautier.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EduRepository extends JpaRepository<Education, Integer> {
    public Optional<Education> findByEduName(String eduName);
    public Optional<Education> findByEduDescription(String eduDescription);
    public boolean existsByEduName(String eduName);
    public boolean existsByEduDescription(String eduDescription);
    public boolean existsById(int id);
}
package com.portfolio.nahuelvautier.Repository;

import com.portfolio.nahuelvautier.Entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProRepository extends JpaRepository<Project, Integer> {
    public Optional<Project> findByProName(String proName);
    public boolean existsByProName(String proName);
    public boolean existsById(int id);
}
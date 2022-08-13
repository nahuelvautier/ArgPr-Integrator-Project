package com.portfolio.nahuelvautier.Repository;

import com.portfolio.nahuelvautier.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpRepository extends JpaRepository<Experience, Integer> {
    public Optional<Experience> findByExpName(String expName);
    public boolean existsByExpName(String expName);
    public boolean existsById(int id);
}

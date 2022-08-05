package com.portfolio.nahuelvautier.Repository;

import com.portfolio.nahuelvautier.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
    
}

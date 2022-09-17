
package com.portfolio.nahuelvautier.Repository;

import com.portfolio.nahuelvautier.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    public boolean existsById(int id);
}

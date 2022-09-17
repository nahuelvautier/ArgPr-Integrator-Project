package com.portfolio.nahuelvautier.Service;

import com.portfolio.nahuelvautier.Entity.Person;
import com.portfolio.nahuelvautier.Repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    
    public List<Person>list() {
        return personRepository.findAll();
    }
    
    public Optional<Person> getOne(int id) {
        return personRepository.findById(id);
    }
    
    public void save(Person person) {
        personRepository.save(person);
    }
    
    public void delete(int id) {
        personRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return personRepository.existsById(id);
    }
    
    public Person findPerson(int id) {
        Person person = personRepository.findById(id).orElse(null);
        return person;
    }
}

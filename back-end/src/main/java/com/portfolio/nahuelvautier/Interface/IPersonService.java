package com.portfolio.nahuelvautier.Interface;

import com.portfolio.nahuelvautier.Entity.Person;
import java.util.List;


public interface IPersonService {
    //Get person list
    public List<Person>getPerson();
    
    //Save an user type of object
    public void savePerson(Person person);
    
    //Delete user by ID
    public void deletePerson(Long id);
    
    //Search user by ID
    public Person findPerson(Long id);
}

package com.portfolio.nahuelvautier.Controller;

import com.portfolio.nahuelvautier.Entity.Person;
import com.portfolio.nahuelvautier.Interface.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("persons")
@RestController
@CrossOrigin(origins = "https://nv-portfolio.web.app/")
public class PersonController {
    @Autowired IPersonService ipersonService;
    
    @GetMapping("/get")
    public List<Person> getPerson() {
        return ipersonService.getPerson();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String createPerson(@RequestBody Person person) {
        ipersonService.savePerson(person);
        return "Usuario creado con éxito.";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        ipersonService.deletePerson(id);
        return "Usuario eliminado con éxito.";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public Person editPerson(
            @PathVariable Long id,
            @RequestParam("name") String newName,
            @RequestParam("lastname") String newLastName,
            @RequestParam("image") String newImage
           ){
        Person person = ipersonService.findPerson(id);
        
        person.setName(newName);
        person.setLastName(newLastName);
        person.setImage(newImage);
        
        ipersonService.savePerson(person);
        return person;
    }
    
    @GetMapping("/get/profile")
    public Person findPerson () {
        return ipersonService.findPerson((long)1);
    }
}

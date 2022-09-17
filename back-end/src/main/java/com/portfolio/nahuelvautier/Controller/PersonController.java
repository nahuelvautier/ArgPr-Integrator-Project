package com.portfolio.nahuelvautier.Controller;

import com.portfolio.nahuelvautier.DTO.DtoPerson;
import com.portfolio.nahuelvautier.Entity.Person;
import com.portfolio.nahuelvautier.Service.PersonService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("persons")
@RestController
@CrossOrigin(origins = "https://nv-portfolio.web.app/")
public class PersonController {
    @Autowired
    PersonService personService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Person>> list() {
        List<Person> list = personService.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/get/profile")
    public Person findPerson() {
        return personService.findPerson((int)4);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id) {
        if(!personService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID."), HttpStatus.BAD_REQUEST);
        }
        
        Person person = personService.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPerson dtoPerson) {
        if(StringUtils.isBlank(dtoPerson.getPersonName())) {
            return new ResponseEntity(new Msg("El nombre de la persona es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPerson.getPersonTitle())) {
            return new ResponseEntity(new Msg("El título de la persona es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPerson.getPersonDescription())) {
            return new ResponseEntity(new Msg("La descripción de la persona es requerida."), HttpStatus.BAD_REQUEST);
        }
        
        Person person = new Person(
                dtoPerson.getPersonName(),
                dtoPerson.getPersonTitle(),
                dtoPerson.getPersonDescription(),
                dtoPerson.getPersonPicture(),
                dtoPerson.getPersonBanner()
        );
        
        personService.save(person);
        return new ResponseEntity(new Msg("La persona ha sido añadida con éxito."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPerson dtoPerson) {
        if(!personService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID seleccionado."), HttpStatus.NOT_FOUND);
        }
        
        if(StringUtils.isBlank(dtoPerson.getPersonName())) {
            return new ResponseEntity(new Msg("El nombre de la persona es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPerson.getPersonTitle())) {
            return new ResponseEntity(new Msg("El título de la persona es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPerson.getPersonDescription())) {
            return new ResponseEntity(new Msg("La descripción de la persona es requerida."), HttpStatus.BAD_REQUEST);
        }
        
        Person person = personService.getOne(id).get();
        
        person.setPersonName(dtoPerson.getPersonName());
        person.setPersonTitle(dtoPerson.getPersonTitle());
        person.setPersonDescription(dtoPerson.getPersonDescription());
        person.setPersonPicture(dtoPerson.getPersonPicture());
        person.setPersonBanner(dtoPerson.getPersonBanner());
        
        personService.save(person);
        return new ResponseEntity(new Msg("La persona ha sido actualizada con éxito."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!personService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID seleccionado."), HttpStatus.NOT_FOUND);
        }
        
        personService.delete(id);
        return new ResponseEntity(new Msg("La persona ha sido eliminada exitosamente."), HttpStatus.OK);
    }
}

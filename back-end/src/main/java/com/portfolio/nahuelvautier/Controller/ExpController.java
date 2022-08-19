package com.portfolio.nahuelvautier.Controller;

import com.portfolio.DTO.DtoExperience;
import com.portfolio.nahuelvautier.Entity.Experience;
import com.portfolio.nahuelvautier.Service.ExpService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("experience")
@RestController
@CrossOrigin(origins = "*")
public class ExpController {
    @Autowired
    ExpService expService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> list = expService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!expService.existsById(id)) {
            return new ResponseEntity(new Msg("La experiencia no existe."), HttpStatus.NOT_FOUND);
        }
        
        Experience experience = expService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperience dtoExperience) {
        if(StringUtils.isBlank(dtoExperience.getExpName())) {
            return new ResponseEntity(new Msg("El nombre de la experiencia es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        if(expService.existsByExpDescription(dtoExperience.getExpDescription())) {
            return new ResponseEntity(new Msg("La descripción es identica a una de las existentes."), HttpStatus.BAD_REQUEST);
        }
        
        Experience experience = new Experience(
                dtoExperience.getExpName(),
                dtoExperience.getExpDescription(),
                dtoExperience.getExpReference(),
                dtoExperience.getExpImage(),
                dtoExperience.getExpSupplier()
        );
        
        expService.save(experience);
        
        return new ResponseEntity(new Msg("Experiencia agregada con éxito."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperience dtoExperience) {
        if(!expService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID seleccionado"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoExperience.getExpName())) {
            new ResponseEntity(new Msg("El nombre de la experiencia es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        Experience experience = expService.getOne(id).get();
        experience.setExpName(dtoExperience.getExpName());
        experience.setExpDescription(dtoExperience.getExpDescription());
        experience.setExpReference(dtoExperience.getExpReference());
        experience.setExpImage(dtoExperience.getExpImage());
        experience.setExpSupplier(dtoExperience.getExpSupplier());
        
        
        expService.save(experience);
        return new ResponseEntity(new Msg("Experiencia actualizada con éxito."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!expService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID seleccionado"), HttpStatus.BAD_REQUEST);
        }
        
        expService.delete(id);
        
        return new ResponseEntity(new Msg("Experiencia eliminada con éxito."), HttpStatus.OK);
    }
}
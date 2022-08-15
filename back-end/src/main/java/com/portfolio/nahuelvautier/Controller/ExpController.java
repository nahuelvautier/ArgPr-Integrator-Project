package com.portfolio.nahuelvautier.Controller;

import com.portfolio.DTO.DtoExperience;
import com.portfolio.nahuelvautier.Entity.Experience;
import com.portfolio.nahuelvautier.Service.ExpService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("experience")
@CrossOrigin(origins = "*")
public class ExpController {
    @Autowired
    ExpService expService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> list = expService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperience dtoExperience) {
        if(StringUtils.isBlank(dtoExperience.getExpName())) {
            return new ResponseEntity(new Msg("El nombre de la experiencia es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        if(expService.existsByExpName(dtoExperience.getExpName())) {
            return new ResponseEntity(new Msg("Esa experiencia ya existe."), HttpStatus.BAD_REQUEST);
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
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperience dtoExperience) {
        if(!expService.existsById(id)) {
            return new ResponseEntity(new Msg("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(expService.existsByExpName(dtoExperience.getExpName()) && expService.getByExpName(dtoExperience.getExpName()).get().getId() != id) {
            return new ResponseEntity(new Msg("Esa experiencia ya existe."), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoExperience.getExpName())) {
            new ResponseEntity(new Msg("El nombre de la experiencia es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        Experience experience = expService.getOne(id).get();
        experience.setExpName(dtoExperience.getExpName());
        experience.setExpDescription(dtoExperience.getExpDescription());
        
        expService.save(experience);
        return new ResponseEntity(new Msg("Experiencia actualizada con éxito."), HttpStatus.OK);
    }
    
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!expService.existsById(id)) {
            return new ResponseEntity(new Msg("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        expService.delete(id);
        
        return new ResponseEntity(new Msg("Experiencia eliminada con éxito."), HttpStatus.OK);
    }
}
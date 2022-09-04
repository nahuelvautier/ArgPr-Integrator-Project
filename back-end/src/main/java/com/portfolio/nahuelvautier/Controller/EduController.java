package com.portfolio.nahuelvautier.Controller;

import com.portfolio.nahuelvautier.DTO.DtoEducation;
import com.portfolio.nahuelvautier.Entity.Education;
import com.portfolio.nahuelvautier.Service.EduService;
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

@RequestMapping("education")
@RestController
@CrossOrigin(origins = "https://nv-portfolio.web.app/")
public class EduController {
    @Autowired
    EduService eduService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = eduService.list(); 
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id) {
        if(!eduService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID."), HttpStatus.BAD_REQUEST);
        }
        
        Education education = eduService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducation dtoEducation) {
        if(StringUtils.isBlank(dtoEducation.getEduName())) {
            return new ResponseEntity(new Msg("El nombre de la edcación es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        if(eduService.existsByEduName(dtoEducation.getEduName())) {
            return new ResponseEntity(new Msg("El nombre de la educación ya existe."), HttpStatus.BAD_REQUEST);
        }
        
        
        if(eduService.existsByEduDescription(dtoEducation.getEduDescription())) {
            return new ResponseEntity(new Msg("La descripción es identica a una de las existentes."), HttpStatus.BAD_REQUEST);
        }
        
        Education education = new Education(
                dtoEducation.getEduName(),
                dtoEducation.getEduCareer(),
                dtoEducation.getEduExpedition(),
                dtoEducation.getEduDescription(),
                dtoEducation.getEduImage()
        );
                
       eduService.save(education);
       return new ResponseEntity(new Msg("Educación añadida con éxito."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducation dtoEducation) {
        if(!eduService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID seleccionado."), HttpStatus.NOT_FOUND);
        }
        
        if(eduService.existsByEduName(dtoEducation.getEduName()) && eduService.getByEduName(dtoEducation.getEduName()).get().getId() != id) {
            return new ResponseEntity(new Msg("El nombre de la educación ya existe."), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducation.getEduName())) {
            return new ResponseEntity(new Msg("El nombre de la educación es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEducation.getEduDescription())) {
            return new ResponseEntity(new Msg("La descripción de la educación es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        Education education = eduService.getOne(id).get();
        
        education.setEduName(dtoEducation.getEduName());
        education.setEduCareer(dtoEducation.getEduCareer());
        education.setEduExpedition(dtoEducation.getEduExpedition());
        education.setEduDescription(dtoEducation.getEduDescription());
        education.setEduImage(dtoEducation.getEduImage());
        
        eduService.save(education);
        return new ResponseEntity(new Msg("Educación actualizada con éxito."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!eduService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID seleccionado."), HttpStatus.NOT_FOUND);
        }
        
        eduService.delete(id);
        return new ResponseEntity(new Msg("Educación eliminada exitosamente."), HttpStatus.OK);
    }
}

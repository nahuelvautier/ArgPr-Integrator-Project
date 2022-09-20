package com.portfolio.nahuelvautier.Controller;

import com.portfolio.nahuelvautier.DTO.DtoHardSoftSkill;
import com.portfolio.nahuelvautier.Entity.HardSoftSkill;
import com.portfolio.nahuelvautier.Service.HardSoftSkillService;
import java.util.List;
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

@RequestMapping("skills")
@RestController
@CrossOrigin(origins = "https://nv-portfolio.web.app/")
public class HardSoftSkillController {
    @Autowired
    HardSoftSkillService hssService;
    
    @GetMapping("/list")
    public ResponseEntity<List<HardSoftSkill>> list() {
        List<HardSoftSkill> list = hssService.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HardSoftSkill> getById(@PathVariable("id") int id) {
        if(!hssService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID."), HttpStatus.BAD_REQUEST);
        }
        
        HardSoftSkill hss = hssService.getOne(id).get();
        return new ResponseEntity(hss, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHardSoftSkill dtoHSS) {
        if(dtoHSS.getHsPercent() > 100) {
            return new ResponseEntity(new Msg("El valor del conocimiento no puede ser mayor a 100."), HttpStatus.BAD_REQUEST);
        }
        
        HardSoftSkill hss = new HardSoftSkill(
                dtoHSS.getHsPercent(),
                dtoHSS.getHsTitle(),
                dtoHSS.getHsImage()
        );
        
        hssService.save(hss);
        return new ResponseEntity(new Msg("Habilidad añadida con éxito."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHardSoftSkill dtoHSS) {
        if(!hssService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID seleccinado."), HttpStatus.NOT_FOUND);
        }
        
        if(dtoHSS.getHsPercent() > 100) {
            return new ResponseEntity(new Msg("El valor del conocimiento no puede ser mayor a 100."), HttpStatus.BAD_REQUEST);
        }
        
        if(hssService.existsByHsTitle(dtoHSS.getHsTitle()) && hssService.getByHsTitle(dtoHSS.getHsTitle()).get().getId() != id) {
            return new ResponseEntity(new Msg("El nombre de la habilidad que intentas actualizar ya existe."), HttpStatus.BAD_REQUEST);
        }
        
        HardSoftSkill hss = hssService.getOne(id).get();
        
        hss.setHsPercent(dtoHSS.getHsPercent());
        hss.setHsTitle(dtoHSS.getHsTitle());
        hss.setHsImage(dtoHSS.getHsImage());
        
        hssService.save(hss);
        return new ResponseEntity(new Msg("Habilidad actualizada con éxito."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id) {
            if(!hssService.existsById(id)) {
                return new ResponseEntity(new Msg("No existe el ID seleccionado."), HttpStatus.BAD_REQUEST);
            }
            
            hssService.delete(id);
            return new ResponseEntity(new Msg("Habilidad eliminada con éxito."), HttpStatus.OK);
        }
}
package com.portfolio.nahuelvautier.Controller;

import com.portfolio.nahuelvautier.DTO.DtoProject;
import com.portfolio.nahuelvautier.Entity.Project;
import com.portfolio.nahuelvautier.Service.ProService;
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


@RequestMapping("projects")
@RestController
@CrossOrigin(origins = "https://nv-portfolio.web.app/")
public class ProController {
    @Autowired
    ProService proService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Project>> list() {
        List<Project> list = proService.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") int id) {
        if(!proService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID."), HttpStatus.BAD_REQUEST);
        }
        
        Project project = proService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProject dtoProject) {
        if(StringUtils.isBlank(dtoProject.getProName())) {
            return new ResponseEntity(new Msg("El nombre del proyecto es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        if(proService.existsByProName(dtoProject.getProName())) {
            return new ResponseEntity(new Msg("El nombre del proyecto ya existe."), HttpStatus.BAD_REQUEST);
        }
        
        Project project = new Project(
                dtoProject.getProName(),
                dtoProject.getProDescription(),
                dtoProject.getProApiUsed(),
                dtoProject.getProExpedition(),
                dtoProject.getProHref()
        );
        
        proService.save(project);
        return new ResponseEntity(new Msg("Proyecto añadido con éxito"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProject dtoProject) {
        if(!proService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID seleccionado."), HttpStatus.NOT_FOUND);
        }
        
        if(proService.existsByProName(dtoProject.getProName()) && proService.getByProName(dtoProject.getProName()).get().getId() != id) {
            return new ResponseEntity(new Msg("El nombre del proyeto ya existe."), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoProject.getProName())) {
            return new ResponseEntity(new Msg("El nombmre del proyecto es requerido."), HttpStatus.BAD_REQUEST);
        }
        
        Project project = proService.getOne(id).get();
        
        project.setProName(dtoProject.getProName());
        project.setProDescription(dtoProject.getProDescription());
        project.setProApiUsed(dtoProject.getProApiUsed());
        project.setProExpedition(dtoProject.getProExpedition());
        project.setProHref(dtoProject.getProHref());
        
        proService.save(project);
        return new ResponseEntity(new Msg("Proyecto actualizado con éxito."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!proService.existsById(id)) {
            return new ResponseEntity(new Msg("No existe el ID seleccionado."), HttpStatus.NOT_FOUND);
        }
        
        proService.delete(id);
        return new ResponseEntity(new Msg("Proyecto eliminado exitosamente."), HttpStatus.OK);
    }
}
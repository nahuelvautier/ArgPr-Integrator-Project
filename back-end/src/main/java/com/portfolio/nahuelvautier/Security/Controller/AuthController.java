package com.portfolio.nahuelvautier.Security.Controller;

import com.portfolio.nahuelvautier.Controller.Msg;
import com.portfolio.nahuelvautier.Security.DTO.JwtDto;
import com.portfolio.nahuelvautier.Security.DTO.LoginUser;
import com.portfolio.nahuelvautier.Security.DTO.NewUser;
import com.portfolio.nahuelvautier.Security.Entity.Role;
import com.portfolio.nahuelvautier.Security.Entity.User;
import com.portfolio.nahuelvautier.Security.Enums.RoleName;
import com.portfolio.nahuelvautier.Security.JWT.JwtProvider;
import com.portfolio.nahuelvautier.Security.Service.RoleService;
import com.portfolio.nahuelvautier.Security.Service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UserService userService;
    
    @Autowired
    RoleService roleService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/new")
    public ResponseEntity<?> newbie(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity(new Msg("Hubo un error al crear la cuenta."), HttpStatus.BAD_REQUEST);
        }
        
        if(userService.existsByUserName(newUser.getUserName())) {
            return new ResponseEntity(new Msg("El nombre de usuario especificado esta en uso."), HttpStatus.BAD_REQUEST);
        }
        
        if(userService.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity(new Msg("El email especificado esta en uso."), HttpStatus.BAD_REQUEST);
        }
        
        User user = new User(
                newUser.getName(),
                newUser.getUserName(),
                newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword())
            );
        
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
        
        if(newUser.getRoles().contains("admin"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());
        
        user.setRoles(roles);
        userService.save(user);
        
        return new ResponseEntity(new Msg("Usuario creado correctamente."), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity(new Msg("Campos no válidos"), HttpStatus.BAD_REQUEST);
        }
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUser.getUserName(), loginUser.getPassword()
        ));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}

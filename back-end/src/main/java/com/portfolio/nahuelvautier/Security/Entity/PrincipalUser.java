package com.portfolio.nahuelvautier.Security.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class PrincipalUser implements UserDetails {
    private String name;
    private String userName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public PrincipalUser(String name, String userName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    
    public static PrincipalUser build(User user) {
        List<GrantedAuthority> authorities = 
                user.getRoles()
                .stream()
                .map(role -> 
                new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
        
        return new PrincipalUser(
                user.getName(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String getUsername() {
        return userName;
    }
    
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }
    
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

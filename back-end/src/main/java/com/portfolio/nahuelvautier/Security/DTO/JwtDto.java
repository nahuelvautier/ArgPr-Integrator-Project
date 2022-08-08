package com.portfolio.nahuelvautier.Security.DTO;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String userName;
    private Collection<? extends GrantedAuthority> authoritys;

    public JwtDto(String token, String userName, Collection<? extends GrantedAuthority> authoritys) {
        this.token = token;
        this.userName = userName;
        this.authoritys = authoritys;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<? extends GrantedAuthority> getAuthoritys() {
        return authoritys;
    }

    public void setAuthoritys(Collection<? extends GrantedAuthority> authoritys) {
        this.authoritys = authoritys;
    }
    
    
}

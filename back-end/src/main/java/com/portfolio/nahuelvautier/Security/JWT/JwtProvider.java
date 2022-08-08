package com.portfolio.nahuelvautier.Security.JWT;

import com.portfolio.nahuelvautier.Security.Entity.PrincipalUser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
     private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
     
     
     @Value("${jwt.secret}")
     private String secret;
     @Value("${jwt.expiration}")
     private int expiration;
     
     public String generateToken(Authentication authentication) {
         PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
         return Jwts.builder().setSubject(principalUser.getUsername())
                 .setIssuedAt(new Date())
                 .setExpiration(new Date(new Date().getTime() + expiration*1000))
                 .signWith(SignatureAlgorithm.HS512, secret)
                 .compact();
     }
     
     public String getUserNameFromToken(String token) {
         return Jwts.parser()
                 .setSigningKey(secret)
                 .parseClaimsJws(token)
                 .getBody()
                 .getSubject();
     }
     
     public boolean validateToken(String token) {
         try {
             Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
             return true;
            } catch (MalformedJwtException err) {
                logger.error("Token mal formado.");
            } catch (UnsupportedJwtException err) {
                logger.error("Token no soportado.");
            } catch (ExpiredJwtException err) {
                logger.error("Token expirado.");
            } catch (IllegalArgumentException err) {
                logger.error("Token vacío.");
            } catch (SignatureException err) {
                logger.error("Token no válida");
            }
         
         return false;
     }
}

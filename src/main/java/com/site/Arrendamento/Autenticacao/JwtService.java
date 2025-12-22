package com.site.Arrendamento.Autenticacao;

import com.site.Arrendamento.entidades.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private  final String Chave=" chave super secreta";

    public String gerarToken(Usuario usuario){
        return Jwts.builder().setSubject(usuario.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date (System.currentTimeMillis()+1000*60*60))
                .signWith(SignatureAlgorithm.HS512, Chave).compact();
    }

      public String extrairEmail(String token){
        return Jwts.parser().setSigningKey(Chave).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean tokenValido(String token, UserDetails userDetails){
        String email = extrairEmail(token);
        return email.equals(userDetails.getUsername());
    }
}

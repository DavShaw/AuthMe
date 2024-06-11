package com.davshaw.authme.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64.Decoder;

import org.springframework.boot.autoconfigure.ssl.SslBundleProperties.Key;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    private final String SecretKey = "WOIEBFUNBGIEURH313246234HFIDHFIGHIOSJDOJ1235325SIDFSODFNDBFSDJBFSLKDJFBSJD234526234567UYHGFSURIGBF";

    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }

    public String getToken(Map<String, Object> claims, UserDetails user) {
        Jwts jwts = Jwts.builder()
        .setClaims(claims)
        .setSubject(user.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .signWith(getKey(), SignatureAlgorithm.HS256)
        .compact();
    }

    private Key getKey() {
        byte [] keyBytes = Decoder.Base64.decode(SecretKey);
        return keyBytes;
    }

}

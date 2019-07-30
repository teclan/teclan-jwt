package com.teclam.jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

/**
 * Jwt 封装一些常用方法
 */
public class JwtFactory {

    private static final SignatureAlgorithm DEFAULT_ALGORITHM=SignatureAlgorithm.HS256;

    private static Key key=null;

    private static Key getKey(){
        return getKey(DEFAULT_ALGORITHM);
    }

    private static Key getKey(SignatureAlgorithm algorithm){
        if(key==null){
            key = Keys.secretKeyFor(algorithm);
        }
        return key;
    }


    private static Key getKey(String algorithm){

        SignatureAlgorithm signatureAlgorithm=null;

        switch(algorithm.toUpperCase().trim()){
            case "HS256":
                signatureAlgorithm = SignatureAlgorithm.HS256;
                break;

            case "HS384":
                signatureAlgorithm = SignatureAlgorithm.HS384;
                break;

            case "HS512":
                signatureAlgorithm = SignatureAlgorithm.HS512;
                break;

            case "RS256":
                signatureAlgorithm = SignatureAlgorithm.RS256;
                break;

            case "RS384":
                signatureAlgorithm = SignatureAlgorithm.RS384;
                break;

            case "RS512":
                signatureAlgorithm = SignatureAlgorithm.RS512;
                break;

            case "ES256":
                signatureAlgorithm = SignatureAlgorithm.ES256;
                break;

            case "ES384":
                signatureAlgorithm = SignatureAlgorithm.ES384;
                break;

            case "ES512":
                signatureAlgorithm = SignatureAlgorithm.ES512;
                break;

            case "PS256":
                signatureAlgorithm = SignatureAlgorithm.PS256;
                break;

            case "PS384":
                signatureAlgorithm = SignatureAlgorithm.PS384;
                break;

            case "PS512":
                signatureAlgorithm = SignatureAlgorithm.PS512;
                break;
        }
        return getKey(signatureAlgorithm);
    }

    public static String getJws(String subject){
        return getJws(subject,getKey());
    }

    public static String getJws(String subject,String algorithm){
        return getJws(subject,getKey(algorithm));
    }


    public static String getJws(String subject,Key key){
        String jws = Jwts.builder().setSubject(subject).signWith(key).compact();
        return jws;
    }


    public static boolean verify(String subject,String jws){
        boolean valid = Jwts.parser().setSigningKey(key).parseClaimsJws(jws).getBody().getSubject().equals(subject);
        return valid;
    }
}

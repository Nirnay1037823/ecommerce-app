package com.example.ecommerce.application.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class TokenService {
    public static final String token_secret = "hellohihowareyouimfine";
    public String createToken(Integer id){
        try{
            Algorithm algoObj = Algorithm.HMAC256(token_secret);
            String token = JWT.
                    create().
                    withClaim("userId",id.toString()).
                    withClaim("createdAt", new Date()).
                    sign(algoObj);
            return token;
        }catch (UnsupportedEncodingException | JWTCreationException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getUserIdToken(String token ) {
        try {
            Algorithm algoObject = Algorithm.HMAC256(token_secret);
            JWTVerifier jwtVerifier = JWT.require(algoObject).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            return decodedJWT.getClaim("userId").asString();
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isTokenValid(String token) {
        String userId = this.getUserIdToken(token);
        return userId!=null;
    }
}

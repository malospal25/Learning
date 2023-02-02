package com.example.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt_secret}")
    private String secret;
    public String generateToken(String username){
        Date expirationDate = Date.from(ZonedDateTime.now().plusMinutes(60).toInstant());

        return JWT.create()                                 // Статический метод create, с помощью него мы можем сконструировать наш JWT - токен, который мы отправим пользователю
                .withSubject("User details")                // Здесь будут храниться данные пользователя
                .withClaim("username", username)      // В теле этого токена необходимо указать те пары ключ  значения которые мы бы хотели поместить
                .withIssuedAt(new Date())                   // Так же мы здесь добавляем то время когда этот JWT токен был создан и выдан (текущее время
                .withIssuer("JWT")                          // Здесь мы помечае кто выдал этот токен  (в настоящем приложении здесь указывается название программы)
                .withExpiresAt(expirationDate)              // Здесь указывае время жизни токена
                .sign(Algorithm.HMAC256(secret));           // Так же мы этот токен должны подписать, добавить к нему эту сигнатуру, и для этого мы должны передать ему какой-нибудь секрет, который хранится только на нашем сервере (Алгоритм шифрования)

    }

    // мы его будем вызывать когда клиент будет слать запрос (мы должны этот токен валидировать, мы еще должны доставать Claim)
    public String validateTokenAndRetrieveClaim(String token) throws JWTVerificationException {
        JWTVerifier verifier =JWT.require(Algorithm.HMAC256(secret))
                .withSubject("User details")
                .withIssuer("JWT")
                .build();
        DecodedJWT jwt = verifier.verify(token);                             // После того как этот токен будет проверифицирован (мы его сможем получить) (декодированный jwt)
        return jwt.getClaim("username").asString();
    }
}

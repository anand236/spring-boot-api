package create_api.test.config;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtConfig {
    @Value("${JWT_SECRET}")
    private String SECRET;

    private Key key(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String email){
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith((javax.crypto.SecretKey) key())
                .compact();
    }

    public String extractEmail(String token){
        try {
            return Jwts.parser()
                    .verifyWith((javax.crypto.SecretKey) key())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        } catch (Exception e){
            return null;
        }
    }
}

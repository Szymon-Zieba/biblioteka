package pl.goread.security.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.goread.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JWTUtils {

    private static final Logger logger = LoggerFactory.getLogger(JWTUtils.class);

    @Value("${jwt.secret}")
    private String JWT_SECRET;

    @Value("${jwt.expiration}")
    private long JWT_EXPIRATION;

    /**
     * We are creating a JWT token with the username as the subject, the current date as the issued date, and the current
     * date plus the expiration time as the expiration date. We are also signing the token with the secret key
     *
     * @param authentication This is the authentication object that contains the user's credentials.
     * @return A JWT token
     */
    public String generateToken(Authentication authentication){
        User userPrincipal = (User) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    /**
     * If the Authorization header starts with "Bearer ", return the token
     *
     * @param request The request object that contains the token.
     * @return The token
     */
    public String parseToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");

        if (StringUtils.hasText(header) && header.startsWith("Bearer ")){
            return header.substring(7);
        }

        return null;
    }

    /**
     * It takes a token, and returns the username that was used to create the token
     *
     * @param token The token that we want to validate.
     * @return The username of the user who is logged in.
     */
    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * If the token is valid, return true, otherwise return false
     *
     * @param token The JWT token to validate
     * @return A boolean value.
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

}

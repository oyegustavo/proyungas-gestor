package ar.org.proyungas.shared.infrastructure.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

public class CurrentUserUtils {

  private CurrentUserUtils() {

  }
  

  public static String getToken(HttpServletRequest httpServletRequest) {
    String authorizationHeader = httpServletRequest.getHeader("Authorization");
    if (authorizationHeader != null) {
      authorizationHeader = authorizationHeader.replace("Bearer ", "");
    }
    return authorizationHeader;
  }

  
  public static String getUsername(HttpServletRequest httpServletRequest) {
		String authorizationHeader = httpServletRequest.getHeader("Authorization");
		String name = "";

  if (authorizationHeader != null) {
			authorizationHeader = authorizationHeader.replace("Bearer ", "");
			Claims claims = Jwts.parserBuilder()
				    .setSigningKey(Keys.hmacShaKeyFor("algun_codigo_secreto_aeiou_mas_largo_123456".getBytes()))
				    .build()
				    .parseClaimsJws(authorizationHeader)
				    .getBody();
			name = (String) claims.get("nombre");
		}
		return name;
  }
}

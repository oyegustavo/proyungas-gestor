package ar.org.proyungas.shared.infrastructure.utils;

import java.util.List;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;

public class CurrentUserUtils {

  private CurrentUserUtils() {

  }
  
	public static UserInfo getUserInfo(HttpServletRequest httpServletRequest) {
		String authorizationHeader = httpServletRequest.getHeader("Authorization");
		String name = "";
		List<String> authorities= null;

    if (authorizationHeader != null) {
			authorizationHeader = authorizationHeader.replace("Bearer ", "");
			Claims claims = Jwts.parser().setSigningKey("algun_codigo_secreto_aeiou".getBytes())
					.parseClaimsJws(authorizationHeader).getBody();
			name = (String) claims.get("user_name");
			authorities = (List<String>) claims.get("authorities");
		}
    
		return UserInfo.builder()
				.username(name)
				.authorities(authorities)
				.build();
	}

  public static String getToken(HttpServletRequest httpServletRequest) {
    String authorizationHeader = httpServletRequest.getHeader("Authorization");
    if (authorizationHeader != null) {
      authorizationHeader = authorizationHeader.replace("Bearer ", "");
    }
    return authorizationHeader;
  }

  public static String getClaim(HttpServletRequest httpServletRequest, String claim) {
    String authorizationHeader = httpServletRequest.getHeader("Authorization");
    String claimResponse = "";
    if (authorizationHeader != null) {
      authorizationHeader = authorizationHeader.replace("Bearer ", "");
      Claims claims = Jwts.parser().setSigningKey("algun_codigo_secreto_aeiou".getBytes())
          .parseClaimsJws(authorizationHeader).getBody();
      if ("exp".equals(claim)) {
        claimResponse = (String) claims.get(claim).toString();
      } else {
        claimResponse = (String) claims.get(claim);
      }

    }
    return claimResponse;
  }
}

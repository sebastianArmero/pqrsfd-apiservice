package com.smartcampus.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.smartcampus.security.models.JwtUser;
import com.smartcampus.security.services.JwtUserDetailsServiceImpl;
import com.smartcampus.security.services.UserDetailsImpl;
//import com.uniajc.smartcampus.loginclient.security.ClaimKeyType;
//import com.uniajc.smartcampus.loginclient.security.JwtTokenUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@SuppressWarnings("unused")
@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -3301605591108950415L;
	
	private static final Logger logger = Logger.getLogger(JwtTokenUtil.class.getName());

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;
	
	@Autowired
	private JwtUserDetailsServiceImpl userDetailsService;
	
	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	public String getUsernameFromToken(String token) {
		String username = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				username = claims.getSubject();
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return username;
	}

	public Date getCreatedDateFromToken(String token) {
		Date created = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				created = new Date((Long) claims.get(ClaimKeyType.CLAIM_KEY_CREATED.getValue()));
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return created;
	}

	public Date getExpirationDateFromToken(String token) {
		Date vencimiento = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				vencimiento = claims.getExpiration();
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return vencimiento;
	}

	public String getAudienceFromToken(String token) {
		String audience = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				audience = (String) claims.get(ClaimKeyType.CLAIM_KEY_AUDIENCE.getValue());
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());		
		}
		return audience;
	}

	public Integer getPegeIdFromToken(String token) {
		Integer pegeId = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				pegeId = (Integer) claims.get(ClaimKeyType.CLAIM_KEY_ID.getValue());
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());		
		}
		return pegeId;
	}

	private Claims getClaimsFromToken(String token) throws MalformedJwtException {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date vencimiento = getExpirationDateFromToken(token);
		return (vencimiento != null) && vencimiento.before(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		JwtUser user = (JwtUser) userDetails;
		final String username = getUsernameFromToken(token);
		return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}

	
	public String generateJwtToken(String user, long pegeId, boolean rememberme) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(user);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
				null, userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(ClaimKeyType.CLAIM_KEY_USERNAME.getValue(), user);
		claims.put(ClaimKeyType.CLAIM_KEY_ID.getValue(), pegeId);
		claims.put(ClaimKeyType.CLAIM_KEY_CREATED.getValue(), new Date());

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setClaims(claims)
				.setIssuedAt(new Date())
				.setExpiration(rememberme ? null : new Date((System.currentTimeMillis() * 1000) + (JWT_TOKEN_VALIDITY * 1000)))
				//.setExpiration(rememberme ? null : new Date((System.currentTimeMillis() * 1000) + (3600000 * 1000)))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	
	
/*	public String getUsernameFromToken(String token) {
		String username = null;
		try {
			final Claims claims = validateToken(token);
			if (claims != null) {
				username = claims.getSubject();
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return username;
	}

	public Date getCreatedDateFromToken(String token) {
		Date created = null;
		try {
			final Claims claims = validateToken(token);
			if (claims != null) {
				created = new Date((Long) claims.get(ClaimKeyType.CLAIM_KEY_CREATED.getValue()));
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return created;
	}

	public Date getExpirationDateFromToken(String token) {
		Date vencimiento = null;
		try {
			final Claims claims = validateToken(token);
			if (claims != null) {
				vencimiento = claims.getExpiration();
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return vencimiento;
	}

	public String getAudienceFromToken(String token) {
		String audience = null;
		try {
			final Claims claims = validateToken(token);
			if (claims != null) {
				audience = (String) claims.get(ClaimKeyType.CLAIM_KEY_AUDIENCE.getValue());
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());		
		}
		return audience;
	}

	public Integer getPegeIdFromToken(String token) {
		Integer pegeId = null;
		try {
			final Claims claims = validateToken(token);
			if (claims != null) {
				pegeId = (Integer) claims.get(ClaimKeyType.CLAIM_KEY_ID.getValue());
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger("JWT claims string is empty: {}", e.getMessage());
		}
		return pegeId;
	}

	private boolean validateToken(String token) throws MalformedJwtException {
		try {
		Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return true;
		}
		return false;
		
	}

	private Boolean isTokenExpired(String token) {
		final Date vencimiento = getExpirationDateFromToken(token);
		return (vencimiento != null) && vencimiento.before(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		JwtUser user = (JwtUser) userDetails;
		final String username = getUsernameFromToken(token);
		return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}
	
	private Claims getClaimsFromToken(String token) throws MalformedJwtException {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	}
	
	public String generateJwtToken(String user,long pegeId, boolean rememberme) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(user);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
				null, userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(ClaimKeyType.CLAIM_KEY_USERNAME.getValue(), user);
		claims.put(ClaimKeyType.CLAIM_KEY_ID.getValue(), pegeId);
		claims.put(ClaimKeyType.CLAIM_KEY_CREATED.getValue(), new Date());

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setClaims(claims)
				.setIssuedAt(new Date())
				.setExpiration(rememberme ? null : new Date((System.currentTimeMillis() * 1000) + (JWT_TOKEN_VALIDITY * 1000)))
				//.setExpiration(rememberme ? null : new Date((System.currentTimeMillis() * 1000) + (3600000 * 1000)))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}
	
*/	
	/*public String generateJwtToken(String user,long pegeId, boolean rememberme) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(user);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
				null, userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(ClaimKeyType.CLAIM_KEY_USERNAME.getValue(), user);
		claims.put(ClaimKeyType.CLAIM_KEY_ID.getValue(), pegeId);
		claims.put(ClaimKeyType.CLAIM_KEY_CREATED.getValue(), new Date());

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setClaims(claims)
				.setIssuedAt(new Date())
				.setExpiration(rememberme ? null : new Date((System.currentTimeMillis() * 1000) + (JWT_TOKEN_VALIDITY * 1000)))
				//.setExpiration(rememberme ? null : new Date((System.currentTimeMillis() * 1000) + (3600000 * 1000)))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}
	
	
	public String getUsernameFromToken(String token) {
		String username = null;
		try {
			//final Claims claims = validateToken(token);
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				username = claims.getSubject();
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return username;
	}

	public Date getCreatedDateFromToken(String token) {
		Date created = null;
		try {
			//final Claims claims = validateToken(token);
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				created = new Date((Long) claims.get(ClaimKeyType.CLAIM_KEY_CREATED.getValue()));
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return created;
	}

	public Date getExpirationDateFromToken(String token) {
		Date vencimiento = null;
		try {
			//final Claims claims = validateToken(token);
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				vencimiento = claims.getExpiration();
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());
		}
		return vencimiento;
	}

	public String getAudienceFromToken(String token) {
		String audience = null;
		try {
//			final Claims claims = validateToken(token);
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				audience = (String) claims.get(ClaimKeyType.CLAIM_KEY_AUDIENCE.getValue());
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());		
		}
		return audience;
	}

	public Integer getPegeIdFromToken(String token) {
		Integer pegeId = null;
		try {
			//final Claims claims = validateToken(token);
			final Claims claims = getClaimsFromToken(token);
			if (claims != null) {
				pegeId = (Integer) claims.get(ClaimKeyType.CLAIM_KEY_ID.getValue());
			}
		} catch (MalformedJwtException | IllegalArgumentException e) {
			Logger.getLogger(JwtTokenUtil.class.getName()).log(Level.SEVERE, e.getMessage());		
		}
		return pegeId;
	}

	private Boolean isTokenExpired(String token) {
		final Date vencimiento = getExpirationDateFromToken(token);
		return (vencimiento != null) && vencimiento.before(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		JwtUser user = (JwtUser) userDetails;
		final String username = getUsernameFromToken(token);
		return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}
	
	private Claims getClaimsFromToken(String token) throws MalformedJwtException {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	}
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.log(Level.FINE,"Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.log(Level.FINE,"Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.log(Level.FINE,"JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.log(Level.FINE,"JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.log(Level.FINE,"JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}*/
}
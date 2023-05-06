package com.example.dividend.sercurity;

import com.example.dividend.service.MemberService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    private static final long TOKEN_EXPIRE_TIME = 1000 * 60 * 60; //1시간(1000 * 60 * 60)
    private static final String KEY_ROLES = "roles";

    private final MemberService memberService;

    @Value("{spring.jwt.secret}")
    private String secretKey;

    /**
     * 토큰 생성(발급)
     *
     * @param username
     * @param roles
     * @return
     */
    public String generateToken(String username, List<String> roles) { //토큰 생성
        Claims claims = Jwts.claims().setSubject(username);
        claims.put(KEY_ROLES, roles);


        var now = new Date();
        var expiredDate = new Date(now.getTime() + TOKEN_EXPIRE_TIME); //얼마나 토큰을 유효하게 할건지 (1시간)

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now) //토근 생성 시간
                .setExpiration(expiredDate) //토큰 만료 시간
                .signWith(SignatureAlgorithm.HS512, this.secretKey) //사용할 암호화 알고리즘, 비밀키
                .compact();
    }

    public Authentication getAuthentication(String jwt) {//인증정보 가져옴
        UserDetails userDetails = this.memberService.loadUserByUsername(this.getUsername(jwt));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return this.parseClaims(token).getSubject();
    }

    public boolean validateToken(String token) {
        if (!StringUtils.hasText(token)) return false;

        var claims = this.parseClaims(token);
        return !claims.getExpiration().before(new Date()); //토큰 이 유효한지 (만료시간이 현재보다 이전인지 아닌지)
    }

    private Claims parseClaims(String token) { //토큰 파싱
        try {
            return Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            //TODO
            return e.getClaims();
        }
    }
}

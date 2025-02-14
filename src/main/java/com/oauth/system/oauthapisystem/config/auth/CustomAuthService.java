package com.oauth.system.oauthapisystem.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 커스텀 auth service
 * <p>
 * Member 테이블에서 사용자정보를 검색 및 role을 부여한다
 */
@Service
@RequiredArgsConstructor
public class CustomAuthService implements UserDetailsService {

    //private final MemberRepository memberRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Member member = memberRepository
//                .findById(username)
//                .orElseThrow(() -> new UsernameNotFoundException("사용자 정보가 없습니다."));

//        CustomUserDetails user = new CustomUserDetails(member.getId(), member.getPwd(), member.getIdx(), member.getDeleteStatusYn());
        CustomUserDetails user = new CustomUserDetails("test","test");

//        List<GrantedAuthority> roles = member
//                .getRoles().stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
        List<GrantedAuthority> roles = Arrays.asList(
                new SimpleGrantedAuthority("ROLE_MEMBER"),
                new SimpleGrantedAuthority("MEMBER")
        );

//        user.setAuthorities(roles);

        return user;

    }

}

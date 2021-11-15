package com.example.pro.config.auth;

import com.example.pro.Repository.AccountRepository;
import com.example.pro.model.user;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


//시큐리티 설정에서
//login요정이 오면 자동으로 UserDetailsService 타입으로 되어있는 IoC되어 있는 loadUserDetailsService 함수가 실행
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;
    //시큐리티 Session((Authentication(UserDetails));
    //이렇게 안쪽으로 들어가게된다
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user userEntity=accountRepository.findByUsername(username);
        if (userEntity!=null){
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}

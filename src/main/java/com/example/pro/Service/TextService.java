package com.example.pro.Service;


import com.example.pro.Repository.AccountRepository;
import com.example.pro.Repository.BoardRepository;
import com.example.pro.model.board;
import com.example.pro.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BoardRepository boardRepository;

    public String comparison(String username, Long id) {
        user user = accountRepository.findByUsername(username);
        String username1 = user.getUsername();//현재 로그인된 사용자
        return username1;
    }



}

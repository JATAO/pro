package com.example.pro.Service;

import com.example.pro.Repository.AccountRepository;
import com.example.pro.Repository.BoardRepository;
import com.example.pro.model.board;
import com.example.pro.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private AccountRepository accountRepository;

    public board save(String username, board board) {
        user user = accountRepository.findByUsername(username);
        board.setUser(user);

        return boardRepository.save(board);
    }

    public void deletedbyid(long id) {
        board board = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시물은 없습니다."+id));
        boardRepository.deleteById(id);
    }
}

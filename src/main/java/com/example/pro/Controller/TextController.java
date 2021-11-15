package com.example.pro.Controller;

import com.example.pro.Repository.BoardRepository;
import com.example.pro.Service.BoardService;
import com.example.pro.Service.TextService;
import com.example.pro.model.board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TextController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private TextService textService;
    @Autowired
    private BoardService boardService;

    @GetMapping("/text")
    public String form(Model model, @RequestParam(required = false) Long id, Authentication authentication
                        ){
        board board2=boardRepository.findById(id).orElse(null);
        model.addAttribute("board",board2);

        String username = authentication.getName();
        String comparison = textService.comparison(username,id);
        model.addAttribute("compas",comparison);
        return "text/text";
    }

    @GetMapping("/delete/{id}")
    @DeleteMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return "redirect:/";
    }




//

}

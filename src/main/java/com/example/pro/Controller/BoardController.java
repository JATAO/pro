package com.example.pro.Controller;



import com.example.pro.Repository.BoardRepository;
import com.example.pro.Service.BoardService;
import com.example.pro.model.board;
import com.example.pro.validator.Boardvalidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;

    @Autowired
    private Boardvalidator boardvalidator;

    @GetMapping("/list")
    public String list(Model model,@PageableDefault(size = 3) Pageable pageable,
                       @RequestParam(required = false,defaultValue = "") String searchText
           ){
      //Page<board> board = boardRepository.findAll(pageable);
         Page<board> board   = boardRepository.findByTitleContainingOrContentContaining(searchText,searchText,pageable);
        int startpage = Math.max(1, board.getPageable().getPageNumber() - 2);
        int endpage = Math.min(board.getTotalPages(), board.getPageable().getPageNumber() + 2);
        int nowpage = board.getPageable().getPageNumber();
        int totalPages = board.getTotalPages();

        model.addAttribute("totalpage",totalPages);
        model.addAttribute("nowpage",nowpage);
        model.addAttribute("startpage",startpage);
        model.addAttribute("endpage",endpage);
        model.addAttribute("board",board);
        return "list/list";
    }

    @GetMapping("/maneger")
        public String manger(){
            return
                    "list/maneger";
        }


    @GetMapping("/admin")
        public String admin(){
            return "list/admin";
        }




    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        if (id == null){
            model.addAttribute("board",new board());
        }else{
         board board=boardRepository.findById(id).orElse(null);
         model.addAttribute("board",board);
        }
        return "list/form";
        }

        @PostMapping("/form")
    public String getform(@Valid board board, BindingResult bindingResult, Authentication authentication
                        ){
        boardvalidator.validate(board,bindingResult);
        if (bindingResult.hasErrors()){
            return "/list/form";
        }
            String username = authentication.getName();
            boardService.save(username,board);
//            boardRepository.save(board);

        return "redirect:/list";
        }



}
//
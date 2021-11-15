package com.example.pro.Controller;


import com.example.pro.Repository.AccountRepository;
import com.example.pro.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
        return
                "account/login";
    }
    @GetMapping("/register")
    public String register(){
        return "account/register";
    }

    @PostMapping("/register")
    public String register2(user user){
        String pass= user.getPassword();
        String endcodpassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(endcodpassword);
        user.setRole("ROLE_USER");
        accountRepository.save(user);
        return "redirect:/";
    }
}

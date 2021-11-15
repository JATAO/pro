package com.example.pro.validator;


import com.example.pro.model.board;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class Boardvalidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return board.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        board b = (board) target;
        if(StringUtils.isEmpty(b.getContent())){
            errors.rejectValue("content", "key","내용을 입력하세요");
        }else{

        }
    }
}

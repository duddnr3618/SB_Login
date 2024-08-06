package com.example.sb_login.user.controller;

import com.example.sb_login.user.dto.UserDto;
import com.example.sb_login.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Console;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @GetMapping("/join")
    public String join() {
        return "user/join";
    }

    @PostMapping("/joinPro")
    public String signupPro(@ModelAttribute UserDto userDto, Model model) {
        System.out.println(" ################# ");
        System.out.println(" 컨트롤러 접근 ");
        System.out.println(" ################# ");
        model.addAttribute("userDto", userDto);
        try {
            if (userDto.getPassword().equals(userDto.getPassword2())) {
                userService.join(userDto);
                return "redirect:/";
            } else {
                model.addAttribute("errorMessage", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
                return "user/join";
            }
        }catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "user/join";
    }

    @GetMapping("/login")
    public String login(){
        return "redirect:/";
    }

}

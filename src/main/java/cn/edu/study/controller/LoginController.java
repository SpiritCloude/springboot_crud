package cn.edu.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @PostMapping("user/login")
    public String login(@RequestParam("username") String user,
                        @RequestParam("password")String pass,
                        Model model,
                        HttpSession session ){
        session.setAttribute("logUser",user);
        if(!StringUtils.isEmpty(user)){
            return "dashboard";
        }else{
            return "login";
        }
    }
}

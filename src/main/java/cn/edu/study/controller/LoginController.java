package cn.edu.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Api("登录")
@Controller
public class LoginController {

    @ApiOperation(value = "登录")
    @PostMapping("user/login")
    public String login(@RequestParam("username") String user,
                        @RequestParam("password")String pass,
                        Model model,
                        HttpSession session ){
        session.setAttribute("logUser",user);
        if(!StringUtils.isEmpty(user)){
            return "redirect:/dashboard";
        }else{
            return "login";
        }
    }

    @ApiOperation(value = "防表单重新提交")
    @GetMapping("/dashboard")
    public String comForm(){
            return "dashboard";
    }
}

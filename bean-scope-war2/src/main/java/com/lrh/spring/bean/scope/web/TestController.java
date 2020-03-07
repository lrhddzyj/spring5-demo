package com.lrh.spring.bean.scope.web;

import com.lrh.spring.bean.scope.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {


    //request scope 的注入的对象实际是被CGlib proxy对象,每次都会产生一个新的出来，而原定义Bean对象实际不会变化
    @Autowired
    User requestScopeUser;


    //Seesion 中的User 是跟着session变化
    @Autowired
    User sessionScopeUser;


   //Seesion 中的User 是跟着session变化
    @Autowired
    User applicationScopeUser;

    @GetMapping("/index2")
    public String index(Model model){
        model.addAttribute("requestScopeUser", requestScopeUser);
        model.addAttribute("sessionScopeUser", sessionScopeUser);
        model.addAttribute("applicationScopeUser", applicationScopeUser);
        return "index2";
    }

}

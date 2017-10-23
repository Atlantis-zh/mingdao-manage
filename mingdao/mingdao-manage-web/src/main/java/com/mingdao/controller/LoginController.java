package com.mingdao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by ambitious on 2017/9/16.
 */

@Controller
public class LoginController {

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userId", 1);
        return "/admin/login";
    }

    @RequestMapping(value="login_copy",method = RequestMethod.GET)
    public String login_Copy(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userId",1);
        return "admin/index";
    }


    @RequestMapping("index")
    public String goToIndex(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userId",1L);
        return "admin/index";
    }


}

package com.mingdao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
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
    public String login(){
        return "/admin/login";
    }


    @RequestMapping("index")
    public String goToIndex(){
        return "admin/index";
    }


}

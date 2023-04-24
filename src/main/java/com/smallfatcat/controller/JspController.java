package com.smallfatcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zsz
 * @Description
 * @date 2022/9/29
 */
@Controller
public class JspController {

    @RequestMapping("/test1")
    public String fun1(){
        return "/test1";
    }

    @RequestMapping("/test2")
    public String fun2(){
        return "/test2";
    }

}

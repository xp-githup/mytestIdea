package com.itheima.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/hello")
public class HelloController {
@RequestMapping("/add")
    @PreAuthorize("hasAuthority('add')")
    public String add(){
    System.out.println("add...");
    return "add";

}

    @RequestMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String update(){
        System.out.println("update...");
        return "update";
    }
    @RequestMapping("/delete")
    @PreAuthorize("hasRole('ABC')")
    public String delete(){
        System.out.println("delete...");
        return "delete";

    }




}

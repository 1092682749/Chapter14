package com.ssm.chapter14.controller;

import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.jws.WebParam;

@Controller
@RequestMapping("/attribute")
@SessionAttributes(names = {"id","di"},types = {Role.class})
public class AttributeController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/requestAttribute")
    public ModelAndView req(@RequestAttribute(name = "id",required = false) Long id)
    {
        System.out.println(id);
        ModelAndView mav = new ModelAndView();
        Role role = roleService.getRole(id);
        mav.setView(new MappingJackson2JsonView());
        mav.addObject("role",role);
        System.out.println(role.getRoleName());
        return mav;
    }
    @RequestMapping("/sessionAttribute")
    public ModelAndView session(Long id)
    {
        ModelAndView mav = new ModelAndView();
        Long di = id + 1;
        mav.addObject("id",id);
        mav.addObject("di",di);
        mav.setViewName("sessionAttribute");
        return mav;
    }
    @RequestMapping("/getHeaderAndCookie")
    public String testHAC(@RequestHeader(value = "User-Agent",required = false,defaultValue = "att")String uA,
                          @CookieValue(value = "JSESSIONID",required = true,defaultValue = "MyssessionId")String id)
    {
        System.out.println("U-A"+uA);
        System.out.println("JS"+id);
        return "index";
    }
}

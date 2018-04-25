package com.ssm.chapter14.controller;

import com.ssm.chapter14.pojo.Format;
import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.service.RoleService;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/converter")
public class ConverterController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/getRole")
    @ResponseBody
    public Role getRole(Long id){
        Role role = roleService.getRole(id);
        return role;
    }
    @RequestMapping("/updateRole")
    @ResponseBody
    public Map<String,Object> updateRole(Role role)
    {
        System.out.println(role.getRoleName());
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("name",role.getRoleName());
        result.put("note",role.getNote());
        return result;
    }
    @RequestMapping("/updateRoleList")
    @ResponseBody
    public Map<String,Object> updateRoleList(List<Role> roles){
        System.out.println(1231231);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("name1",roles.get(0).getRoleName());
        result.put("name2",roles.get(1).getRoleName());
        return result;
    }
    @RequestMapping("/format")
    public ModelAndView format(@RequestParam("date1") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)Date date, @RequestParam("amount1")@NumberFormat(pattern = "#,###.##")Double amount)
    {
           ModelAndView mav = new ModelAndView("index");
           mav.addObject("date",date);
           mav.addObject("amount",amount);
           System.out.println(date);
           System.out.println(amount);
           return mav;
    }

    @RequestMapping("/formatPojo")
    public ModelAndView formatPojo(Format data)
    {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("date",data.getDate());
        mav.addObject("amount",data.getAmount());
        System.out.println(data.toString());
        return mav;
    }
}

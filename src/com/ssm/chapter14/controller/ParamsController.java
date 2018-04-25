package com.ssm.chapter14.controller;

import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@Controller
@RequestMapping("/params")
public class ParamsController {
    @Autowired
    RoleService roleService;
    @RequestMapping("/commonParams")
    public ModelAndView commonParams(String roleName,String note)
    {
        System.out.println("roleName=>"+roleName);
        System.out.println("note=>"+note);
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    @RequestMapping("/commonParamsPojo")
    public ModelAndView commonParams(Role role)
    {
        System.out.println(role.getRoleName());
        System.out.println(role.getNote());
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    /**
     * 字段名字一致的时候不需要@RequestParam绑定
     * @param roleName
     * @param note
     * @return
     */
    @RequestMapping("/requestParam")
    public ModelAndView requestParam(@RequestParam("role_name") String roleName,@RequestParam("role_note") String note)
    {
        System.out.println("roleName=>"+roleName);
        System.out.println("note=>"+note);
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    /**
     * 对象接收表单参数需要字段名字一致
     * @param role
     * @return
     */
    @RequestMapping("/requestParam2")
    public ModelAndView requestParam2(Role role)
    {
        System.out.println("roleName=>"+role.getRoleName());
        System.out.println("note=>"+role.getNote());
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    /**
     * 使用url传递参数
     */
    @RequestMapping("/getRole/{id}")
    public ModelAndView pathVariable(@PathVariable("id") Long id)
    {
        Role role = roleService.getRole(1L);
        ModelAndView mav = new ModelAndView();
        mav.addObject("role",role);
        mav.setView(new MappingJackson2JsonView());
        return mav;
    }
    @RequestMapping(value = "/findRole",method = RequestMethod.POST)
    public ModelAndView findRole()
    {
        System.out.println("json");
        List<Role> roles = roleService.findeRole();
        for (Role role:roles)
        {
            System.out.println(role.getRoleName());
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("roles",roles);
        mav.setView(new MappingJackson2JsonView());
        System.out.println("json2");
        return mav;
    }
    @RequestMapping("/showRoleJsonInfo")
    public ModelAndView showRoleJsonInfo(Long uid,String roleName,String note)
    {
        ModelAndView mav = new ModelAndView();
        mav.setView(new MappingJackson2JsonView());
        mav.addObject("roleName",roleName);
//        mav.addObject("id",id);
        mav.addObject("uid",uid);
        mav.addObject("note",note);
        return mav;
    }
    @RequestMapping("/addRole")
    public String addRole(Model model,String roleName,String note)
    {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setNote(note);
        role.setUid(1L);
        roleService.insertRole(role);
        model.addAttribute("roleName",roleName);
        model.addAttribute("note",note);
        model.addAttribute("id",role.getId());
        model.addAttribute("uid",1L);
        return "redirect:./showRoleJsonInfo.do";
    }
    @RequestMapping("/addRole2")
    public ModelAndView addRole2(ModelAndView mav,String roleName,String note)
    {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setNote(note);
        role.setUid(1L);
        roleService.insertRole(role);
        mav.addObject("roleName",roleName);
        mav.addObject("note",note);
        mav.addObject("uid",1L);
        mav.setViewName("redirect:./showRoleJsonInfo.do");
        return mav;
    }
    @RequestMapping("/addRole3")
    public String addRole3(RedirectAttributes ra)
    {
        Role role = new Role();
        role.setRoleName("123");
        role.setNote("asd");
//        ModelAndView mav = new ModelAndView();
        ra.addFlashAttribute("role",role);
        return "redirect:./showRoleJsonInfo2.do";
    }
    @RequestMapping("/showRoleJsonInfo2")
    public ModelAndView showRoleJsonInfo2(Role role)
    {
        System.out.println("json2");
        ModelAndView mav = new ModelAndView();
        mav.setView(new MappingJackson2JsonView());
        mav.addObject("role",role);
        return mav;
    }
}

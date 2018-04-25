package com.ssm.chapter14.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.*;
import javax.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class UpdataController {
    @RequestMapping("/upload")
    public ModelAndView upload(HttpServletRequest request)
    {
        System.out.println("123");
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest)request;
        MultipartFile file = mhsr.getFile("file");
        ModelAndView mav = new ModelAndView();
        mav.setView(new MappingJackson2JsonView());
        String fileName = file.getOriginalFilename();
        File dest = new File(fileName);
        try{
            file.transferTo(dest);
            mav.addObject("success",true);
            mav.addObject("msg","上传文件成功");
        }catch (IllegalStateException e)
        {
            mav.addObject("success",false);
            mav.addObject("msg","上传文件失败");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("/uploadMultipartFile")
    public ModelAndView multipartFile(MultipartFile file){
        ModelAndView mav = new ModelAndView();
        mav.setView(new MappingJackson2JsonView());
        String fileName = file.getOriginalFilename();
        file.getContentType();
        File dest = new File(fileName);
        try
        {
            file.transferTo(dest);
            mav.addObject("success",true);
            mav.addObject("msg","上传文件成功");
        }catch (IllegalStateException | IOException e)
        {
            mav.addObject("success",false);
            mav.addObject("msg","上传文件失败");
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("/uploadPart")
    public ModelAndView uploadPart(Part file)
    {
        ModelAndView mav = new ModelAndView();
        mav.setView(new MappingJackson2JsonView());
        String fileName = file.getName();
        File dest = new File(fileName);
        try
        {
            file.write(" /Users/qingyun/Desktop/mvc ");
            mav.addObject("success",true);
            mav.addObject("msg","上传文件成功");
        }catch (IllegalStateException | IOException e)
        {
            mav.addObject("success",false);
            mav.addObject("msg","上传文件失败");
            e.printStackTrace();
        }
        return mav;
    }
}

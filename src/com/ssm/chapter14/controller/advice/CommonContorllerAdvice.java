package com.ssm.chapter14.controller.advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;
@ControllerAdvice(basePackages = {"com.ssm.chapter14.controller.advice"})
public class CommonContorllerAdvice {
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
    }

    @ModelAttribute
    public void populateModel(Model model){
        model.addAttribute("projectName","chapter16");
    }

    @ExceptionHandler(Exception.class)
    public String exception(){
        return "exception";
    }
}

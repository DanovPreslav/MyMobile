package com.java.mymobile.web;

import org.springframework.web.servlet.ModelAndView;



public  abstract  class BaseController {

    //Може да копирам това и да си го поставя в проекта ако реша да  използвам BaseController!!!!!!!!!!!!!!!

    public ModelAndView view(String viewName, ModelAndView modelAndView) {
        modelAndView.setViewName(viewName);

        return modelAndView;
    }

    public ModelAndView view(String viewName) {
        return this.view(viewName, new ModelAndView());
    }

    public ModelAndView redirect(String url) {
        return this.view("redirect:" + url); // redirect:redirect:/url
    }
}

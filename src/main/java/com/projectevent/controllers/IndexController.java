package com.projectevent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class IndexController {
    // @GetMapping
    // public String indexString() {
    // return "index";
    // }

    @GetMapping
    public ModelAndView index() {

        return new ModelAndView("index");
    }
}

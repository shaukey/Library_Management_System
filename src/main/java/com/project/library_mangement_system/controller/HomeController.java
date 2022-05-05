package com.project.library_mangement_system.controller;

import com.project.library_mangement_system.model.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @Autowired
    private HomeService homeService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("topTiles", homeService.getTopTilesMap());
        return "home";
    }
}

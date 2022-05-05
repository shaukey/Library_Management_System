package com.project.library_mangement_system.controller;

import com.project.library_mangement_system.model.Category;
import com.project.library_mangement_system.model.CategoryService;
import com.project.library_mangement_system.model.Constants;
import com.project.library_mangement_system.model.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/issue")
public class IssueController {

    @Autowired
    private IssueService issueService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute(name = "memberTypes")
    public List<String> memberTypes() {

        return Constants.MEMBER_TYPES;
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {

        return categoryService.getAllBySort();
    }

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listIssuePage(Model model) {
        model.addAttribute("issues", issueService.getAllUnreturned());
        return "/issue/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newIssuePage(Model model) {
        return "/issue/form";
    }

}

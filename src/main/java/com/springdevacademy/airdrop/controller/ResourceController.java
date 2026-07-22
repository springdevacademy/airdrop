package com.springdevacademy.airdrop.controller;

import com.springdevacademy.airdrop.model.ResourceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.springdevacademy.airdrop.repository.ResourceRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import com.springdevacademy.airdrop.model.Resource;

@Controller
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("resources", resourceRepository.findAll());
        return "index";
    }

    @GetMapping("/admin/add")
    public String showAddForm(Model model) {
        model.addAttribute("resource", new ResourceItem());
        return "add-resource";
    }

    @PostMapping("/admin/add")
    public String saveResource(@ModelAttribute ResourceItem resource) {
        resourceRepository.save(resource);
        return "redirect:/";
    }
}

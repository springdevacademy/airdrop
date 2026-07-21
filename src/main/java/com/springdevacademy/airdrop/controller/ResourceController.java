package com.springdevacademy.airdrop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.springdevacademy.airdrop.repository.*;
import com.springdevacademy.airdrop.model.Resource;

@Controller
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("resources", resourceRepository.findAll());
        return "index";
    }
}
package com.kwork.orgibiz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    //    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public String home() {
        return "home";
    }

    //    @PreAuthorize("isAnonymous()")
    @GetMapping("/sign-in")
    public String signIn() {
        return "sign-in";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminPage() {
        return "admin-page";
    }

    @GetMapping("/forbidden")
    public String forbiddenPage() {
        return "forbidden";
    }

    @GetMapping("/add-org")
    public String addPage() {
        return "add-org";
    }

    @PostMapping("/add-org")
    public String blogPostAdd(@RequestParam String nameOrg, @RequestParam int number, @RequestParam String address, Model model) {
        return "redirect:/";
    }
}

package com.pack.webstore.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import
org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
@RequestMapping("/")
public String welcome(Model model) {
model.addAttribute("greeting", "Welcome toWeb Store!");
model.addAttribute("tagline", "The one andonly amazing web store");
return "welcome";
} }
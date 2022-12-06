package com.srenhrkea.eksamensprojekte22.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class employeeController {

  @GetMapping("/employee")
  public String employee(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    String userType = (String) session.getAttribute("userType");
    if(userType==null) {
      redirectAttributes.addFlashAttribute("message", "You must be logged in to access this page.");
      return "redirect:signin";
    }
    return "employee";
  }

  @GetMapping("/test")
  public String test(Model model) {
    return "test";
  }
}

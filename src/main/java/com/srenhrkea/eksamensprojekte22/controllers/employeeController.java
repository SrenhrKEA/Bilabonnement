package com.srenhrkea.eksamensprojekte22.controllers;

import com.srenhrkea.eksamensprojekte22.models.dtos.CustomerDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class employeeController {

  @GetMapping("/employee")
  public String employee(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    String userType = (String) session.getAttribute("userType");
    if (userType == null) {
      redirectAttributes.addFlashAttribute("message", "You must be logged in to access this page.");
      return "redirect:signin";
    }
    return "employee";
  }

  @GetMapping("/test")
  public String test(Model model) {
    return "test";
  }

  @PostMapping("/form-create-customer")
  public String formDRCustomer(Model model) {

    return "redirect:test?step=form_create_lease";
  }

  ;
}

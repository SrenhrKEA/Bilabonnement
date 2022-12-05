package com.srenhrkea.eksamensprojekte22.controllers;

import com.srenhrkea.eksamensprojekte22.models.User;
import com.srenhrkea.eksamensprojekte22.models.UserDTO;
import com.srenhrkea.eksamensprojekte22.services.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class adminController {

  private UserServiceImpl userService;

  public adminController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String login(Model model) {
    return "login";
  }

  @PostMapping("/loginUser")
  public String loginUser(@ModelAttribute UserDTO userDTO, ModelMap model, HttpSession session, RedirectAttributes redirectAttributes) {
    User user;
    try {
      user = userService.AuthenticateUser(userDTO.getUsername(), userDTO.getPassword());
    } catch (Exception e) {
      System.out.println(e.getMessage());
      redirectAttributes.addFlashAttribute("message", "Login failed. Invalid username or password");
      return "redirect:/admin/login";
    }
    if (user != null) {
      setLoginSessionAttributes(session, user);
      return "redirect:/admin";
    } else {
      redirectAttributes.addFlashAttribute("message", "Login failed. Invalid username or password");
      return "redirect:/admin/login";
    }
  }

  @GetMapping("")
  public String admin(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    String userType = (String) session.getAttribute("userType");
    if(userType==null) {
      redirectAttributes.addFlashAttribute("message", "You must be logged in to access this page.");
      return "redirect:/admin/login";
    }
    model.addAttribute("userType", userType);
    return "admin";
  }

  public void setLoginSessionAttributes(HttpSession session, User user) {
    session.setAttribute("username", user.getUsername());
    session.setAttribute("userType", String.valueOf(user.getUserType()));
  }
}

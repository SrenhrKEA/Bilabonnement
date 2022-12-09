package com.srenhrkea.eksamensprojekte22.controllers;

import com.srenhrkea.eksamensprojekte22.models.User;
import com.srenhrkea.eksamensprojekte22.models.dtos.UserDTO;
import com.srenhrkea.eksamensprojekte22.services.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class signinController {

  private UserServiceImpl userService;

  public signinController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @GetMapping("/signin")
  public String login(Model model) {
    return "signin";
  }

  @PostMapping("/signinUser")
  public String loginUser(@ModelAttribute UserDTO userDTO, ModelMap model, HttpSession session, RedirectAttributes redirectAttributes) {
    User user;
    try {
      user = userService.AuthenticateUser(userDTO.getUsername(), userDTO.getPassword());
    } catch (Exception e) {
      System.out.println(e.getMessage());
      redirectAttributes.addFlashAttribute("message", "Log ind fejlede. Dit brugernavn eller kodeord er angivet forkert");
      return "redirect:/signin";
    }
    if (user != null) {
      setLoginSessionAttributes(session, user);
      return "redirect:/employee";
    } else {
      redirectAttributes.addFlashAttribute("message", "Log ind fejlede. Dit brugernavn eller kodeord er angivet forkert");
      return "redirect:/signin";
    }
  }

  private void setLoginSessionAttributes(HttpSession session, User user) {
    session.setAttribute("username", user.getUsername());
    session.setAttribute("userType", String.valueOf(user.getUserType()));
    session.setMaxInactiveInterval(600); //ends session 10 min after last use.
  }
}

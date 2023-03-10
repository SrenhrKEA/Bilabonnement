package com.srenhrkea.eksamensprojekte22.controllers;

import com.srenhrkea.eksamensprojekte22.entities.User;
import com.srenhrkea.eksamensprojekte22.dtos.UserDTO;
import com.srenhrkea.eksamensprojekte22.services.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
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
  public String login() {
    return "signin";
  }

  /*Metode der kontrollere om brugernavnet findes i databasen og hvorvidt kodeordet passer dertil. Hvis ikke sendes brugeren tilbage til sign-in siden*/
  @PostMapping("/signinUser")
  public String loginUser(@ModelAttribute UserDTO userDTO, HttpSession session, RedirectAttributes redirectAttributes) {
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

  @GetMapping("/signoutUser")
  public String signout(HttpSession session) {
    session.invalidate();
    return"redirect:/signin";
  }

  /*Metode der gemmer username og usertype i en session. Usertype bestemmer hvilke dele af webapplikationen brugeren har adgang til */
  private void setLoginSessionAttributes(HttpSession session, User user) {
    session.setAttribute("username", user.getUsername());
    session.setAttribute("userType", String.valueOf(user.getUserType()));
    session.setMaxInactiveInterval(600); //session slutter efter 10 min, hvis man ikke r??r ved noget.
  }
}

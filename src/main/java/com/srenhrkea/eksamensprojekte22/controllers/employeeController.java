package com.srenhrkea.eksamensprojekte22.controllers;

import com.srenhrkea.eksamensprojekte22.models.*;
import com.srenhrkea.eksamensprojekte22.models.dtos.CustomerDTO;
import com.srenhrkea.eksamensprojekte22.services.impl.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.List;

@Controller
public class employeeController {
  @Autowired
  private CustomerServiceImpl customerService;
  private CarTypeRefServiceImpl carTypeRefService;
  private PickupLocationRefServiceImpl pickupLocationRefService;
  private EquipmentRefServiceImpl equipmentRefService;
  private KilometragePlanRefServiceImpl kilometragePlanRefService;

  public employeeController(CustomerServiceImpl customerService, CarTypeRefServiceImpl carTypeRefService, PickupLocationRefServiceImpl pickupLocationRefService, EquipmentRefServiceImpl equipmentRefService, KilometragePlanRefServiceImpl kilometragePlanRefService) {
    this.customerService = customerService;
    this.carTypeRefService = carTypeRefService;
    this.pickupLocationRefService = pickupLocationRefService;
    this.equipmentRefService = equipmentRefService;
    this.kilometragePlanRefService = kilometragePlanRefService;
  }

  @GetMapping("/employee")
  public String employee(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    String userType = (String) session.getAttribute("userType");
    if (userType == null) {
      redirectAttributes.addFlashAttribute("message", "Du skal være logged ind for at få adgang til denne side.");
      return "redirect:signin";
    }
    try {
      List<CarTypeRef> carTypeRefs = carTypeRefService.getAllCarTypeRefs();
      model.addAttribute("carTypeRefs", carTypeRefs);
      List<PickupLocationRef> pickupLocationRefs = pickupLocationRefService.getAllPickupLocationRefs();
      model.addAttribute("pickupLocationRefs", pickupLocationRefs);
      List<EquipmentRef> equipmentRefs = equipmentRefService.getAllEquipmentRefs();
      model.addAttribute("equipmentRefs", equipmentRefs);
      List<KilometragePlanRef> kilometragePlanRefs = kilometragePlanRefService.getAllKilometragePlanRefs();
      model.addAttribute("kilometragePlanRefs", kilometragePlanRefs);
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Der skete en database fejl.");
      return "redirect:signin";
    }
    return "employee";
  }

  @GetMapping("/test")
  public String test(Model model) {
    return "test";
  }

  @PostMapping("/form-create-customer")
  public String formDRCustomer(Model model, @ModelAttribute CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
    Customer customer = new Customer();
    customer.setFirstName(customerDTO.getFirstName());
    customer.setLastName(customerDTO.getLastName());
    customer.setAddress(customerDTO.getAddress());
    customer.setCity(customerDTO.getCity());
    customer.setPostalCode(customerDTO.getPostalCode());
    customer.setNationality(customerDTO.getNationality());
    customer.setContactNo(customerDTO.getContactNo());
    customer.setEmail(customerDTO.getEmail());
    customer.setLicenceNo(customerDTO.getLicenceNo());
    try {
      customerService.saveCustomer(customer);
      redirectAttributes.addFlashAttribute("message", "Kunden er gemt.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Kunden kunne ikke gemmes, da den allerede findes.");
    }
    return "redirect:employee"; //?step=form_create_lease
  }

  ;
}

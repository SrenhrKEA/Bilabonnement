package com.srenhrkea.eksamensprojekte22.controllers;

import com.srenhrkea.eksamensprojekte22.enums.SubscriptionType;
import com.srenhrkea.eksamensprojekte22.models.*;
import com.srenhrkea.eksamensprojekte22.models.dtos.CarDTO;
import com.srenhrkea.eksamensprojekte22.models.dtos.CustomerDTO;
import com.srenhrkea.eksamensprojekte22.models.dtos.LeaseDTO;
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
import java.util.Date;
import java.util.List;

@Controller
public class employeeController {
  private CustomerServiceImpl customerService;
  private CarTypeRefServiceImpl carTypeRefService;
  private PickupLocationRefServiceImpl pickupLocationRefService;
  private EquipmentRefServiceImpl equipmentRefService;
  private KilometragePlanRefServiceImpl kilometragePlanRefService;
  private CarServiceImpl carService;
  private LeaseServiceImpl leaseService;
  private EquipmentServiceImpl equipmentService;
  private KilometragePlanServiceImpl kilometragePlanService;
  private PickupLocationServiceImpl pickupLocationService;
  private DamageReportServiceImpl damageReportService;
  private DamageServiceImpl damageService;

  public employeeController(CustomerServiceImpl customerService, CarTypeRefServiceImpl carTypeRefService, PickupLocationRefServiceImpl pickupLocationRefService, EquipmentRefServiceImpl equipmentRefService, KilometragePlanRefServiceImpl kilometragePlanRefService, CarServiceImpl carService, LeaseServiceImpl leaseService, EquipmentServiceImpl equipmentService, KilometragePlanServiceImpl kilometragePlanService, PickupLocationServiceImpl pickupLocationService, DamageReportServiceImpl damageReportService, DamageServiceImpl damageService) {
    this.customerService = customerService;
    this.carTypeRefService = carTypeRefService;
    this.pickupLocationRefService = pickupLocationRefService;
    this.equipmentRefService = equipmentRefService;
    this.kilometragePlanRefService = kilometragePlanRefService;
    this.carService = carService;
    this.leaseService = leaseService;
    this.equipmentService = equipmentService;
    this.kilometragePlanService = kilometragePlanService;
    this.pickupLocationService = pickupLocationService;
    this.damageReportService = damageReportService;
    this.damageService = damageService;
  }

  @GetMapping("/employee")
  public String employee(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    String userType = (String) session.getAttribute("userType");
    if (userType == null) {
      redirectAttributes.addFlashAttribute("message", "Du skal være logged ind for at få adgang til denne side.");
      return "redirect:signin";
    }
/*    try {
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
    }*/
    return "employee";
  }

  @GetMapping("/customer-form")
  public String customerForm(Model model, RedirectAttributes redirectAttributes) {
    try {
      List<Customer> customers = customerService.getAllCustomers();
      model.addAttribute("customers", customers);
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Der er opstået en fejl i databasen. Listen med kunder kunne ikke hentes");
      return "redirect:employee";
    }
    return "employee-customer";
  }


  @PostMapping("/customer-form-create")
  public String customerFormCreate(Model model, @ModelAttribute CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
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
    return "redirect:customer-form"; //?step=form_create_lease
  }

  @PostMapping("customer-form-update")
  public String customerFormUpdate(Model model, @ModelAttribute CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
    Customer customer = new Customer();
    customer.setIdCustomer(customerDTO.getIdCustomer());
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
      customerService.updateCustomer(customer);
      redirectAttributes.addFlashAttribute("message", "Kunden er gemt.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Kunden kunne ikke gemmes.");
    }
    return "redirect:customer-form"; //?step=form_create_lease
  }

  @GetMapping("/car-form")
  public String carForm(Model model, RedirectAttributes redirectAttributes) {
    try {
      List<CarTypeRef> carTypeRefs = carTypeRefService.getAllCarTypeRefs();
      model.addAttribute("carTypeRefs", carTypeRefs);
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Der er opstået en fejl i databasen. Listen med biltyper kunne ikke hentes");
      return "redirect:employee";
    }
    return "employee-car";
  }


  @PostMapping("/car-form-create")
  public String carFormCreate(Model model, @ModelAttribute CarDTO carDTO, RedirectAttributes redirectAttributes) {
    Car car = new Car();
    car.setAvailable(carDTO.isAvailable());
    car.setIdCarType(carDTO.getIdCarType());
    car.setInitialKilometrage(carDTO.getInitialKilometrage());
    car.setIdCarVIN(carDTO.getIdCarVIN());
    car.setRegNo(carDTO.getRegNo());
    try {
      carService.saveCar(car);
      redirectAttributes.addFlashAttribute("message", "Bilen er gemt.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Bilen kunne ikke gemmes, da den allerede findes.");
    }
    return "redirect:car-form"; //?step=form_create_lease
  }

  @PostMapping("car-form-update")
  public String carFormUpdate() {
    return "redirect:car-form";
  }

  @GetMapping("/lease-form")
  public String leaseForm(Model model, RedirectAttributes redirectAttributes) {
    try {
      List<Lease> leases = leaseService.getAllLeases();
      model.addAttribute("leases", leases);
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Der er opstået en fejl i databasen. Listen med lejeaftaler kunne ikke hentes");
      return "redirect:employee";
    }
    return "employee-lease";
  }

  @PostMapping("/lease-form-create")
  public String leaseFormCreate(Model model, @ModelAttribute LeaseDTO leaseDTO, RedirectAttributes redirectAttributes) {
    Lease lease = new Lease();
    lease.setDurationMonths(leaseDTO.getDurationMonths());
    lease.setIdCustomer(leaseDTO.getIdCustomer());
    lease.setDateOfRent(leaseDTO.getDateOfRent());
    lease.setDateOfReturn(leaseDTO.getDateOfReturn());
    lease.setSubscriptionType(leaseDTO.getSubscriptionType());
    lease.setIdCarVIN(leaseDTO.getIdCarVIN());
    try {
      leaseService.saveLease(lease);
      redirectAttributes.addFlashAttribute("message", "Lejeaftalen er gemt.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Lejeaftalen kunne ikke gemmes, da den allerede findes.");
    }
    return "redirect:lease-form"; //?step=form_create_lease
  }

  @PostMapping("lease-form-update")
  public String leaseFormUpdate() {
    return "redirect:lease-form";
  }

  @GetMapping("/damage-form")
  public String damageForm(Model model, RedirectAttributes redirectAttributes) {
/*    try {
      List<Car> cars = carService.getAllCars(); //TODO: kun available
      model.addAttribute("cars", cars);
      List<DamageReport> damageReports = damageReportService.getAllDamageReports();
      model.addAttribute("damageReports", damageReports); //TODO: by Car
      List<Damage> damages = damageService.getAllDamages(); //TODO: by DamageReport
      model.addAttribute("damages", damages);

    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Der er opstået en fejl i databasen. En af listerne kunne ikke hentes");
      return "redirect:employee";
    }*/
    return "employee-damage";
  }


/*  @PostMapping("/damage-form-create")
  public String damageFormCreate(Model model, @ModelAttribute CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
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

  @PostMapping("damage-form-update")
  public String damageFormUpdate() {
    return "";
  }*/

  @GetMapping("/dashboard")
  public String dashboard(Model model, RedirectAttributes redirectAttributes) {
/*    try {
      List<Customer> customers = customerService.getAllCustomers();
      model.addAttribute("customers", customers);
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Der er opstået en fejl i databasen. Listen med kunder kunne ikke hentes");
      return "redirect:employee";
    }*/
    return "employee-dashboard";
  }

  @GetMapping("/test")
  public String test(Model model) {
    return "test";
  }
}

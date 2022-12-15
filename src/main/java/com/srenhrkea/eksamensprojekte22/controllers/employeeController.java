package com.srenhrkea.eksamensprojekte22.controllers;

import com.srenhrkea.eksamensprojekte22.dtos.*;
import com.srenhrkea.eksamensprojekte22.entities.*;
import com.srenhrkea.eksamensprojekte22.services.impl.*;
import jakarta.servlet.http.HttpSession;
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

  /*forside*/
  @GetMapping("/employee")
  public String employee(HttpSession session, RedirectAttributes redirectAttributes) {
    String userType = (String) session.getAttribute("userType");
    if (userType == null) {
      redirectAttributes.addFlashAttribute("message", "Du skal være logged ind for at få adgang til denne side.");
      return "redirect:signin";
    }
    return "employee";
  }

  /*kunde*/
  @GetMapping("/customer-form")
  public String customerForm(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    String userType = (String) session.getAttribute("userType");
    if (userType == null) {
      redirectAttributes.addFlashAttribute("message", "Du skal være logged ind for at få adgang til denne side.");
      return "redirect:signin";
    }
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
  public String customerFormCreate(@ModelAttribute CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
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
    return "redirect:customer-form";
  }

  @PostMapping("customer-form-update")
  public String customerFormUpdate(@ModelAttribute CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
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
    return "redirect:customer-form";
  }

  /*bil*/
  @GetMapping("/car-form")
  public String carForm(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    String userType = (String) session.getAttribute("userType");
    if (userType == null) {
      redirectAttributes.addFlashAttribute("message", "Du skal være logged ind for at få adgang til denne side.");
      return "redirect:signin";
    }
    try {
      List<CarTypeRef> carTypeRefs = carTypeRefService.getAllCarTypeRefs();
      model.addAttribute("carTypeRefs", carTypeRefs);
      List<Car> cars = carService.getAllCars();
      model.addAttribute("cars", cars);
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Der er opstået en fejl i databasen.");
      return "redirect:employee";
    }
    return "employee-car";
  }

  @PostMapping("/car-form-create")
  public String carFormCreate(@ModelAttribute CarDTO carDTO, RedirectAttributes redirectAttributes) {
    Car car = new Car();
    car.setIdCarVIN(carDTO.getIdCarVIN());
    car.setAvailable(carDTO.getIsAvailable());
    car.setIdCarTypeRef(carDTO.getIdCarTypeRef());
    car.setInitialKilometrage(carDTO.getInitialKilometrage());
    car.setIdCarVIN(carDTO.getIdCarVIN());
    car.setRegNo(carDTO.getRegNo());
    try {
      carService.saveCar(car);
      redirectAttributes.addFlashAttribute("message", "Bilen er gemt.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Bilen kunne ikke gemmes.");
    }
    return "redirect:car-form";
  }

  @PostMapping("car-form-update")
  public String carFormUpdate(@ModelAttribute CarDTO carDTO, RedirectAttributes redirectAttributes) {
    Car car = new Car();
    car.setAvailable(carDTO.getIsAvailable());
    car.setIdCarTypeRef(carDTO.getIdCarTypeRef());
    car.setInitialKilometrage(carDTO.getInitialKilometrage());
    car.setIdCarVIN(carDTO.getIdCarVIN());
    car.setRegNo(carDTO.getRegNo());
    try {
      carService.saveCar(car);
      redirectAttributes.addFlashAttribute("message", "Bilen er gemt.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Bilen kunne ikke gemmes, da den allerede findes.");
    }
    return "redirect:car-form";
  }

  /*lejeaftale, lokation og kilometerplan*/
  @GetMapping("/lease-form")
  public String leaseForm(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    String userType = (String) session.getAttribute("userType");
    if (userType == null) {
      redirectAttributes.addFlashAttribute("message", "Du skal være logged ind for at få adgang til denne side.");
      return "redirect:signin";
    }
    try {
      List<Lease> leases = leaseService.getAllLeases();
      model.addAttribute("leases", leases);
      List<Customer> customers = customerService.getAllCustomers();
      model.addAttribute("customers", customers);
      List<Car> cars = carService.getAllCars();
      model.addAttribute("cars", cars);
      List<PickupLocationRef> pickupLocationRefs = pickupLocationRefService.getAllPickupLocationRefs();
      model.addAttribute("pickupLocationRefs", pickupLocationRefs);
      List<KilometragePlanRef> kilometragePlanRefs = kilometragePlanRefService.getAllKilometragePlanRefs();
      model.addAttribute("kilometragePlanRefs", kilometragePlanRefs);
      List<PickupLocation> pickupLocations = pickupLocationService.getAllPickupLocations();
      model.addAttribute("pickupLocations", pickupLocations);
      List<KilometragePlan> kilometragePlans = kilometragePlanService.getAllKilometragePlans();
      model.addAttribute("kilometragePlans", kilometragePlans);
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Der er opstået en fejl i databasen.");
      return "redirect:employee";
    }
    return "employee-lease";
  }

  @PostMapping("/lease-form-create")
  public String leaseFormCreate(@ModelAttribute LeaseDTO leaseDTO, RedirectAttributes redirectAttributes) {
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
    return "redirect:lease-form";
  }

  @PostMapping("/lease-form-pl")
  public String leaseFormPL(@ModelAttribute PickupLocationDTO pickupLocationDTO, RedirectAttributes redirectAttributes) {
    PickupLocation pickupLocation = new PickupLocation();
    pickupLocation.setIdLease(pickupLocationDTO.getIdLease());
    pickupLocation.setIdPickupLocationRef(pickupLocationDTO.getIdPickupLocationRef());
    try {
      pickupLocationService.savePickupLocation(pickupLocation);
      redirectAttributes.addFlashAttribute("message", "Lokation er gemt.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Lokation kunne ikke gemmes, da den allerede findes.");
    }
    return "redirect:lease-form";
  }

  @PostMapping("/lease-form-kp")
  public String leaseFormKP(@ModelAttribute KilometragePlanDTO kilometragePlanDTO, RedirectAttributes redirectAttributes) {
    KilometragePlan kilometragePlan = new KilometragePlan();
    kilometragePlan.setIdLease(kilometragePlanDTO.getIdLease());
    kilometragePlan.setIdKilometragePlanRef(kilometragePlanDTO.getIdKilometragePlanRef());
    try {
      kilometragePlanService.saveKilometragePlan(kilometragePlan);
      redirectAttributes.addFlashAttribute("message", "Kilometerpakken er gemt.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Kilometerpakken kunne ikke gemmes, da den allerede findes.");
    }
    return "redirect:lease-form";
  }

  @PostMapping("lease-form-delete")
  public String leaseFormUpdate(@ModelAttribute LeaseDTO leaseDTO, RedirectAttributes redirectAttributes) {
    int id = leaseDTO.getIdLease();
    try {
      leaseService.deleteLeaseById(id);
      redirectAttributes.addFlashAttribute("message", "Lejeaftalen er annulleret.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Lejeaftalen kunne ikke annulleres.");
    }
    return "redirect:lease-form";
  }

  @PostMapping("/lease-form-pl-delete")
  public String leaseFormPlUpdate(@ModelAttribute PickupLocationDTO pickupLocationDTO, RedirectAttributes redirectAttributes) {
    int id = pickupLocationDTO.getIdPickupLocation();
    try {
      pickupLocationService.deletePickupLocationById(id);
      redirectAttributes.addFlashAttribute("message", "Lokation er annulleret.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Lokation kunne ikke annulleres.");
    }
    return "redirect:lease-form";
  }

  @PostMapping("/lease-form-kp-delete")
  public String leaseFormKpUpdate(@ModelAttribute KilometragePlanDTO kilometragePlanDTO, RedirectAttributes redirectAttributes) {
    int id = kilometragePlanDTO.getIdKilometragePlan();
    try {
      kilometragePlanService.deleteKilometragePlanById(id);
      redirectAttributes.addFlashAttribute("message", "Kilometerpakken er annulleret.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Kilometerpakken kunne ikke annulleres.");
    }
    return "redirect:lease-form";
  }

  /*Skadesanmeldelse og skade*/
  @GetMapping("/damage-form")
  public String damageForm(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    String userType = (String) session.getAttribute("userType");
    if (userType == null) {
      redirectAttributes.addFlashAttribute("message", "Du skal være logged ind for at få adgang til denne side.");
      return "redirect:signin";
    }
    try {
      List<Car> cars = carService.getAllCarsByIsAvailable();
      model.addAttribute("cars", cars);
      List<DamageReport> damageReports = damageReportService.getAllDamageReports();
      model.addAttribute("damageReports", damageReports);
      List<Damage> damages = damageService.getAllDamages();
      model.addAttribute("damages", damages);
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Der er opstået en fejl i databasen. En af listerne kunne ikke hentes.");
      return "redirect:employee";
    }
    return "employee-damage";
  }

  @PostMapping("/damage-report-form-create")
  public String damageReportFormCreate(@ModelAttribute DamageReportDTO damageReportDTO, RedirectAttributes redirectAttributes) {
    DamageReport damageReport = new DamageReport();
    damageReport.setIdCarVIN(damageReportDTO.getIdCarVIN());
    damageReport.setDateOfReport(damageReportDTO.getDateOfReport());

    try {
      damageReportService.saveDamageReport(damageReport);
      redirectAttributes.addFlashAttribute("message", "Skadesanmeldelsen er gemt.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Skadesanmeldelsen kunne ikke gemmes, da den allerede findes.");
    }
    return "redirect:damage-form"; //?step=form_create_lease
  }

  @PostMapping("damage-report-form-delete")
  public String damageReportFormUpdate(@ModelAttribute DamageReportDTO damageReportDTO, RedirectAttributes redirectAttributes) {
    int id = damageReportDTO.getIdDamageReport();
    try {
      damageReportService.deleteDamageReportById(id);
      redirectAttributes.addFlashAttribute("message", "Skadesanmeldelsen er annulleret.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Skadesanmeldelsen kunne ikke annulleres.");
    }
    return "redirect:damage-form"; //?step=form_create_lease
  }

  @PostMapping("/damage-form-create")
  public String damageFormCreate(@ModelAttribute DamageDTO damageDTO, RedirectAttributes redirectAttributes) {
    Damage damage = new Damage();
    damage.setIdDamageReport(damageDTO.getIdDamageReport());
    damage.setTitle(damageDTO.getTitle());
    damage.setDescription(damageDTO.getDescription());
    damage.setPrice(damageDTO.getPrice());

    try {
      damageService.saveDamage(damage);
      redirectAttributes.addFlashAttribute("message", "Skaden er gemt.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Skaden kunne ikke gemmes, da den allerede findes.");
    }
    return "redirect:damage-form"; //?step=form_create_lease
  }

  @PostMapping("damage-form-delete")
  public String damageFormUpdate(@ModelAttribute DamageDTO damageDTO, RedirectAttributes redirectAttributes) {
    int id = damageDTO.getIdDamage();
    try {
      damageService.deleteDamageById(id);
      redirectAttributes.addFlashAttribute("message", "Skaden er annulleret.");
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Skaden kunne ikke annulleres.");
    }
    return "redirect:damage-form"; //?step=form_create_lease
  }

  /*dashboard*/
  @GetMapping("/dashboard")
  public String dashboard(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    String userType = (String) session.getAttribute("userType");
    if (userType == null) {
      redirectAttributes.addFlashAttribute("message", "Du skal være logged ind for at få adgang til denne side.");
      return "redirect:signin";
    }
    try {
      List<Car> carsLeased = carService.getAllCarsByIsNotAvailable();
      model.addAttribute("carsLeased", carsLeased);
      List<Car> carsParked = carService.getAllCarsByIsAvailable();
      model.addAttribute("carsParked", carsParked);
      double carIncome = carService.GetIncomePerMonth();
      model.addAttribute("carIncome", carIncome);
      double kpIncome = kilometragePlanService.GetIncomePerMonth();
      model.addAttribute("kpIncome", kpIncome);
    } catch (SQLException e) {
      redirectAttributes.addFlashAttribute("message", "Der er opstået en fejl i databasen.");
      return "redirect:employee";
    }
    return "employee-dashboard";
  }

  /*test - bruges ikke*/
  @GetMapping("/test")
  public String test() {
    return "test";
  }
}

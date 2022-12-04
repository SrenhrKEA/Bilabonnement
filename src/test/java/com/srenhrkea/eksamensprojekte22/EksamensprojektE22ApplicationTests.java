package com.srenhrkea.eksamensprojekte22;

import com.srenhrkea.eksamensprojekte22.daos.impl.UserDAOImpl;
import com.srenhrkea.eksamensprojekte22.enums.UserType;
import com.srenhrkea.eksamensprojekte22.models.Car;
import com.srenhrkea.eksamensprojekte22.models.User;
import com.srenhrkea.eksamensprojekte22.services.impl.CarServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EksamensprojektE22ApplicationTests {
@Autowired
  private CarServiceImpl carService;
  /*@Test*/
  void contextLoads() {
  }

  @Test
  void methodeTest () {
/*    carService.saveCar(new Car(true, 1, 2, 1000, "7473474f", "124324F"));
    carService.saveCar(new Car(true, 2, 1, 1000, "7w23423f", "33422GR"));*/
/*    System.out.println(carService.getCarById("7w23423f"));
    System.out.println(carService.getAllCars());*/
    carService.updateCar(new Car(true, 2, 1, 1000, "7w23423f", "33422GR"), "JEGHARRET");
    /*System.out.println(carService.getCarById("JEGHARRET"));*/
    /*carService.deleteCarById("888888DK");*/
  }

}

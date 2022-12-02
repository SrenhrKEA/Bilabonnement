package com.srenhrkea.eksamensprojekte22;

import com.srenhrkea.eksamensprojekte22.daos.impl.UserDAOImpl;
import com.srenhrkea.eksamensprojekte22.enums.UserType;
import com.srenhrkea.eksamensprojekte22.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EksamensprojektE22ApplicationTests {
@Autowired
  private UserDAOImpl userDAOImpl;
  /*@Test*/
  void contextLoads() {
  }

  @Test
  void methodeTest () {
/*
    System.out.println(userDAOImpl.get("Sigrid"));
*/
/*
    System.out.println(userDAOImpl.save(new User("Sigrid","123", UserType.ADMIN)));
*/
/*
    System.out.println(userDAOImpl.update(new User("Sigrid","1234",UserType.BUSINESS)));
*/
/*
    System.out.println(userDAOImpl.delete(new User("Sigrid","1234",UserType.BUSINESS)));
*/
/*    User user = new User("Sigrid","123", UserType.ADMIN);
    System.out.println(String.valueOf(String.valueOf(user.getUserType()).toUpperCase()));*/
    //TODO: save, update og delete metoderne lader til at virke, men den ville have jeg ændrede metoderne til at returnere en boolean i stedet for void, hvilket jeg ikke forstår. Ved ikke om det gør nogen forskel.

    System.out.println(userDAOImpl.getAll());


  }

}

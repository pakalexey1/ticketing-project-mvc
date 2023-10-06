package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.enums.Gender;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.RoleServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;

    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L,"Admin");
        RoleDTO managerRole = new RoleDTO(2L,"Manager");
        RoleDTO employeeRole = new RoleDTO(3L,"Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John","Kesy","john@cydeo.com","Abc1",true,"7459684532",managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike","Smith","mike@cydeo.com","Abc1",true,"7459684534",adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa","Norre","mike@cydeo.com","Abc1",true,"7459684522",managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig","Jack","craig@cydeo.com","Abc1",true,"7452774534",employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun","Hayns","shaun@cydeo.com","Abc1",true,"7452774530",managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizabeth","Loren","elizabeth@cydeo.com","Abc1",true,"2159684522",employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria","Ada","maria@cydeo.com","Abc1",true,"2159684523",employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill","Matt","bill@cydeo.com","Abc1",true,"8452774534",employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);
    }
}

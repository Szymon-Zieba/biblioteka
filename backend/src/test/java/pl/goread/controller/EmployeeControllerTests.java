package pl.goread.controller;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.goread.model.Role;
import pl.goread.model.User;
import pl.goread.repository.UserRepository;
import pl.goread.security.jwt.JWTUtils;
import pl.goread.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserService userService;

    @MockBean
    private JWTUtils jwtUtils;

    @Test
    public void getEmployees() throws Exception {

        Role role = new Role();
        role.setName("ROLE_EMPLOYEE");

        User user = new User();
        user.setRole(role);
        user.setLastName("Imie");
        user.setFirstName("Nazwisko");
        user.setZip("39-120");
        user.setEmail("email@com.com");
        user.setPhoneNumber("321312321");
        user.setPESEL("321312312321");
        user.setCity("Rzeszow");
        user.setEnabled(true);

        User user2 = new User();
        user2.setRole(role);
        user2.setLastName("Imie2");
        user2.setFirstName("Nazwisko2");
        user2.setZip("39-1202");
        user2.setEmail("email@com.com2");
        user2.setPhoneNumber("3213123221");
        user2.setPESEL("3213123123231");
        user2.setCity("Rzeszow2");
        user2.setEnabled(false);

        List<User> userList = new ArrayList<>();

        Mockito.when(userRepository.getEmployees()).thenReturn(userList);
        String url = "/employees";

        mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getEmployeeById() throws Exception {

        Role role = new Role();
        role.setName("ROLE_EMPLOYEE");

        User user = new User();
        user.setId((long)2);
        user.setRole(role);
        user.setLastName("Imie");
        user.setFirstName("Nazwisko");
        user.setZip("39-120");
        user.setEmail("email@com.com");
        user.setPhoneNumber("321312321");
        user.setPESEL("321312312321");
        user.setCity("Rzeszow");
        user.setEnabled(true);

        Mockito.when(userRepository.getEmployeeById(user.getId())).thenReturn(user);
        String url = "/employee/" + user.getId();

        mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }
}

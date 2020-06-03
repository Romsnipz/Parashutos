package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import spring.DTOs.InfoHTTPPojo;
import spring.DTOs.LoginPair;
import spring.DTOs.UserHTTPPojo;
import spring.service.ClientService;


@Controller
@RequestMapping("/")
@Transactional
public class MainController {

    @Autowired
    ClientService clientService;

    public MainController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/")
    public @ResponseBody String index() {
        return "HI THERE";
    }

    @RequestMapping("/registration")
    public @ResponseBody LoginPair registerUser(@RequestBody UserHTTPPojo user) {

        LoginPair loginPair = clientService.registerUser(user);
        return loginPair;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody LoginPair doLogin(@RequestParam("login") String userEmail, @RequestParam("password") String userPassword) {

        LoginPair loginPair = clientService.doLogin(userEmail, userPassword);
        return loginPair;
    }

    @RequestMapping("/save")
    public @ResponseBody String saveInfo(@RequestBody InfoHTTPPojo info) {

        Boolean result = clientService.saveInfo(info);
        return result ? HttpStatus.OK.toString() : HttpStatus.INTERNAL_SERVER_ERROR.toString();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody String getAllUsers() {
        return clientService.getAllClients();
    }
}

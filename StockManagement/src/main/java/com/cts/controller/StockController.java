package com.cts.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.entity.User;

@RestController
@RequestMapping("user")
public class StockController {

@RequestMapping("fetch")
public ModelAndView getData() {
ModelAndView mv = new ModelAndView("user/users");
System.out.println("finding all users");
return mv;
}

// @RequestMapping(value="login", method=RequestMethod.GET)
@GetMapping("login")
public String getLoginPage() {
return "user/login";
}

// @RequestMapping(value="login", method=RequestMethod.POST)
@PostMapping("login")
// public ModelAndView getLogin(@RequestParam("emailId") String email, @RequestParam String password) {
public ModelAndView getLogin(@ModelAttribute User user) {
ModelAndView mav = null;
String email = user.getE_Mail();
String password = user.getPassword();
System.out.println(email);
System.out.println(password);
if(email.equals("admin@gmail.com") && password.equals("890")) {
System.out.println("valid user");
mav = new ModelAndView("user/welcome");
mav.addObject("data", "Welocome "+email);
} else {
System.out.println("invalid user");
mav = new ModelAndView("user/login");
}
return mav;
}

@GetMapping("register")
public String getRegistrationPage() {
return "user/register";
}

@PostMapping("register")
public String getRegistration(@ModelAttribute @Valid User user, BindingResult result, Model model) {
// @RequestParam String username -> user.setUsername(requestParam->username)

System.out.println(user);


System.out.println(result.hasErrors());
if(result.hasErrors()) {
return "user/register";
} else {

model.addAttribute("user", user);
return "user/newuser";
}
}} 	 
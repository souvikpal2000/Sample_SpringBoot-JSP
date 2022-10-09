package com.example.wiprojsp01.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.wiprojsp01.entity.Users;
import com.example.wiprojsp01.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository repo;
	
	@GetMapping("")
	public String LoginPage() {
		return "Login";
	}
	
	@PostMapping("login")
	public String login(Users user, Model m) {
		Users u = repo.findUser(user.getUsername());
		if(u == null) {
			m.addAttribute("message", "User is not Registered");
			return "Login";
		} else {
			Users check = repo.checkUserPassword(user.getUsername(), user.getPassword());
			if(check != null) {
				m.addAttribute("user", check);
				return "Home";
			}else {
				m.addAttribute("message", "Wrong Password");
				return "Login";
			}
		}
	}
	
	@GetMapping("register")
	public String RegisterPage() {
		return "Register";
	}
	
	@PostMapping("register")
	public String addUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("conPassword") String conPassword, Model m) {
		if(password.equals(conPassword) == false) {
			m.addAttribute("message", "Password doesn't Match");
		} else {
			Users u = repo.findUser(username);
			if(u != null) {				
				m.addAttribute("message", "User is already Registered");
			} else {
				Users newUser = new Users(username, password);
				repo.save(newUser);
				m.addAttribute("message", "User Registered");
			}
		}
		return "Register";
	}
	
	@GetMapping("/changepassword")
	public String changePassword() {
		return "ChangePassword";
	}
	
	@Transactional
	@PostMapping("/changepassword")
	public String changePassword(@RequestParam("username") String username, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("conPassword") String conPassword, Model m) {
		Users u = repo.findUser(username);
		if(u != null) {
			Users check = repo.checkUserPassword(username, oldPassword);
			if(check == null) {
				m.addAttribute("message", "Old Password is Incorrect");
			} else {
				if(newPassword.equals(conPassword) == false) {
					m.addAttribute("message", "Password doesn't Match");
				} else {
					if(oldPassword.equals(newPassword) == true) {
						m.addAttribute("message", "New & Old Password is Same");
					} else {
						repo.updatePassword(username, newPassword);
						m.addAttribute("message", "Password Updated");
					}
				}
			}
		} else {
			m.addAttribute("message", "User is not Registered");
		}
		return "ChangePassword";
	}
}

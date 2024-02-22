package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tunehub.entities.Songs;
import com.example.tunehub.entities.Users;
import com.example.tunehub.services.SongsService;
import com.example.tunehub.services.UsersService;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	@Autowired
	UsersService userv;
	@Autowired
	SongsService songserv;
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) 
	
	{
	  boolean userstatus=userv.emailExists(user.getEmail());
	  if(userstatus==false) {
		  userv.addUser(user);
		  return "registersuccess";
	  }else {
		  System.out.println("user is already exist");
	  }
		
		return "registerfail";
		
		
	}
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session) 
	{
		
		if(userv.validateUser(email,password)==true) 
		{
			session.setAttribute("email", email);
			
			if(userv.getRole(email).equals("Admin")) 
			{
				return "adminhome";
			}
		else
		{
			return "customerhome";
		}
	}
	else {
		return "loginfail";
	}
	}
 @GetMapping("/exploresongs")
 public String exploreSongs(HttpSession session ,Model model) {
	 String email=(String) session.getAttribute("email");
	Users user= userv.getUser(email);
	 boolean userstatus=user.isPremium();
	 if(userstatus == true) {
		 
		 List<Songs> slist = songserv.findAllSongs();

			model.addAttribute("slist", slist);
		 return "displaysongs";
	 }
	 else {
		 return "samplePayment";
	 }
 }
 
 @GetMapping("/logout")
 public String logout(HttpSession session) {
	 session.invalidate();
	 return "login";
 }
 @GetMapping("/back")
 public String Back(HttpSession session) {
	 session.invalidate();
	 return "adminhome";
 }
 @GetMapping("/return")
 public String Back1(HttpSession session) {
	 session.invalidate();
	 return "index";
 }
 
	
	
}

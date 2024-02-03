package com.skilldistillery.gamequest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.gamequest.data.UserDAO;
import com.skilldistillery.gamequest.entities.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;

	@GetMapping(value = { "/", "home.do", "" })
	public String home() {
		// User u = userDAO.authenticateUser("JohnnyCage", "123");
		// model.addAttribute("loggedIn", u);
		return "home";
	}

	@GetMapping(value = "login.do")
	public String showLoginBlank() {
		return "LoginBlank";
	}

	@GetMapping(value = "register.do")
	public String showRegisterBlank() {
		return "RegisterBlank";
	}

	// userLogin.do - handle user login
	@PostMapping(value = "userLogin.do")
	public String userLogin(User user, HttpSession session) {
		User currentUser = (User) session.getAttribute("loggedIn");
		if (currentUser != null) {
			return "redirect:home.do";
		} else {
			User loggedInUser = userDAO.authenticateUser(user.getUsername(), user.getPassword());
			if (loggedInUser == null) {
				return "redirect:loginNoUser.do";
			} else {
				if (loggedInUser.isEnabled() == true) {
					session.setAttribute("loggedIn", loggedInUser);
					return "redirect:home.do";
				} else {
					return "redirect:deactivatedUser.do";
				}
			}
		}
	}

	@GetMapping(value="loginNoUser.do")
	public String loginNoUser() {
		return "LoginNoUser";
	}
	
	@GetMapping(value="deactivatedUser.do")
	public String deactivatedUser() {
		return "DeactivatedUser";
	}
	
	// handle logout.do
	@GetMapping(value="logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("loggedIn");
		return "home";
	}
	
	// userRegister.do - handle user register
	@PostMapping(value = "userRegister.do")
	public String userRegister(User user, HttpSession session,RedirectAttributes redir) {
		User currentUser = (User) session.getAttribute("loggedIn");
		if (currentUser != null) {
			session.removeAttribute("loggedIn");
			return "redirect:register.do";
		}
		if (userDAO.findUserByUsername(user.getUsername())!=null) {
			redir.addFlashAttribute("username", user.getUsername());
			return "redirect:registerDuplicatedUser.do";
		}else {
			user.setEnabled(true);
			userDAO.addUser(user);
			return "redirect:registerSuccess.do";
		}
		
	}
	
	@GetMapping(value="registerDuplicatedUser.do")
	public String registerDuplicatedUser(String username, Model model) {
		return "RegisterDuplicatedUser";
	}
	
	@GetMapping(value="registerSuccess.do")
	public String registerSuccess() {
		return "RegisterSuccess";
	}

}

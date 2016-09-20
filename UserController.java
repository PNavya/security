package com.niit.ShoppingCart.controller;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.dao.UserDetailsDAO;
import com.niit.ShoppingCart.model.Category;
import com.niit.ShoppingCart.model.Supplier;
import com.niit.ShoppingCart.model.UserDetails;

@Controller
public class UserController {

	// when the user clicked login
	// based on the credentials,I want find whether he is admin or not
	// if he is admin,I want to navigate to adminHome page
	// if he is user,I want to navigate to home page
	// if the user does not exist with this credentials,i want to give error
	// messages
	@Autowired
	UserDetailsDAO userdetailsDAO;

	@Autowired
	UserDetails user;
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;

	/*@RequestMapping("/check")
	public ModelAndView login(@RequestParam(value="name") String name,@RequestParam(value="password") String password,HttpSession session)
	{
		ModelAndView mv=new ModelAndView("bootstrap");
		String msg;
		user=userdetailsDAO.isValidUser(name,password);
		if(user==null)
		{
			msg="Invalid User...please try again";
		}
		else
		{
			//find out whether the user is admin or not
			if(user.getRole().equals("ROLE_ADMIN"))
			{
				mv=new ModelAndView("adminhome");
				session.setAttribute("WelcomeMsg",user.getName());
				session.setAttribute("userId",user.getuserId());
			}
			else
			{
				mv.addObject("WelcomeMsg",user.getName());
			}
		}
		return mv;
	}*/
	
	@RequestMapping(value="/login_session_attributes")
	public String login_session_attributes(HttpSession session,Model model,@RequestParam(value="username") String userId){
		Object name=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("inside security check");
		
		session.setAttribute("name", name);
		System.out.println(name);
		
		user=userdetailsDAO.get(userId);
		session.setAttribute("loggedInUser", user.getName());
    	session.setAttribute("loggedInUserID", user.getuserId());
    	
		session.setAttribute("LoggedIn", "true");
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		String role="ROLE_USER";
		for(GrantedAuthority authority : authorities)
		{
			if(authority.getAuthority().equals(role))
			{
				System.out.println(role);
				return "bootstrap";
			}
			else
			{
				session.setAttribute("isAdmin", "true");
			}
			}
		return "adminhome" ;
		
		
	}
	
	@RequestMapping("/perform_logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView("bootstrap");
		session.invalidate();
		session=request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());
		
		mv.addObject("logOutMessage", "You have successfully logged out!");
		mv.addObject("loggedout","true");
		
		return mv;
}
	
	@RequestMapping("/signup")
	public ModelAndView SignUp() {
		System.out.println("signup");
		return new ModelAndView("signup");
	}
	@ModelAttribute
	public UserDetails returnObject()
	{
		return new UserDetails();
	}

	@RequestMapping("/validate")
	public ModelAndView ValidateSignUpPage(@Valid @ModelAttribute("userdetails") UserDetails user, BindingResult result,
			HttpServletRequest request) throws IOException {
		System.out.println("In SignUp page");
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		System.out.println(user.getPassword());
		System.out.println(user.getConfirmpassword());
		
		if (user.getConfirmpassword().equals(user.getPassword())) {
			userdetailsDAO.save(user);
		}
		return new ModelAndView("Login");

	}

}

package com.niit.ShoppingCart.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

//import com.niit.ShoppingCart.model.Product;

@Controller
public class HomeController {
	
	
	@Autowired
	private UserDetails user;
	@Autowired
	private UserDetailsDAO userdetailsDAO;
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@RequestMapping("/")
	public ModelAndView showHome()
	{
		ModelAndView mv=new ModelAndView("bootstrap");
		return mv;
	}

	@RequestMapping("/Login")
	public ModelAndView showSignin()
	{
		ModelAndView mv=new ModelAndView("Login");
		return mv;
	}

	
	@ModelAttribute
	public UserDetails returnObject()
	{
		return new UserDetails();
	}
	
	/*@RequestMapping("/check")
	public ModelAndView login(@RequestParam("name")String name,@RequestParam("password")String password,HttpSession session){
        log.debug("Starting of the method login");
        log.info("userID is {} password is {}",name,password);
        
        System.out.println("In validate sign in page "+name+" "+password);
        
        ModelAndView mv=new ModelAndView("signup");; 
        //boolean isValidUser=  userDAO.isValidUser(userID,password);
        
        if(userdetailsDAO.isValidUser(user.getName(),user.getPassword()) == null){
        	user=userdetailsDAO.get("name");
        	session.setAttribute("loggedInUser", user.getName());
        	session.setAttribute("loggedInUserID", user.getId());
        	
        	session.setAttribute("User", user);
        	
        	if(user.getRole().equals("ROLE_ADMIN")){
        		mv.addObject("isAdmin", "true");
        		session.setAttribute("supplier",supplier);
        		session.setAttribute("supplierList",supplierDAO.list());
        		
        		session.setAttribute("category",category);
        		session.setAttribute("categoryList",categoryDAO.list());
        		return new ModelAndView("adminhome");
        		
           	}
        	else{
        		//mv.addObject("isAdmin", "false");
        		cart=cartDAO.get(UserID);
        		mv.addObject("cart", cart);
        		//Fetch the cartList based on USERID
        		mv.addObject("cartList", cartList);
        		mv.addObject("cartSize", cartList.size());
              	}        		
        	}else{
        		mv.addObject("invalidCredentials", "true");
        		mv.addObject("errorMessage", "Invalid Credentials");
        }
        //log.debug("Ending of method login");
        return mv;
	}
	
	@RequestMapping("/logout")
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
	public ModelAndView SignUp()
    {
		System.out.println("signup");
		return new ModelAndView("signup");
	}

	@RequestMapping("/validate")
	public ModelAndView ValidateSignUpPage(@Valid @ModelAttribute("userdetails") UserDetails user, BindingResult result,
			HttpServletRequest request) throws IOException {
		System.out.println("In SignUp page");
		user.setRole("ROLE_USER");

		System.out.println(user.getPassword());
		System.out.println(user.getConfirmpassword());
		
		if (user.getConfirmpassword().equals(user.getPassword())) {
			userdetailsDAO.save(user);
		}
		return new ModelAndView("Login");

	}
*/
}

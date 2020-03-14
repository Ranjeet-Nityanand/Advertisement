package com.mohshiri.advertisement.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohshiri.advertisement.dto.Response;
import com.mohshiri.advertisement.dto.UserDto;
import com.mohshiri.advertisement.model.Status;
import com.mohshiri.advertisement.model.User;
import com.mohshiri.advertisement.services.CompanyServiceHandler;
import com.mohshiri.advertisement.services.UserServiceHandler;
import com.mohshiri.advertisement.utilities.Converter;


/**
 * @author Ranjeet
 *
 */
@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserServiceHandler userService;
	@Autowired
	CompanyServiceHandler companyService;
	
	
	
	@GetMapping("/")
	public String welcomeMessage() {
		return "😎😎😎Working❤😎😎😎";
	}
	
	/**
	 * @author Ranjeet
	 * @param user
	 * @return
	 */
	
	@PostMapping("/signup")
	public Response signup(@RequestBody UserDto user) {
		Response res=new Response();
		User u=new User();
		Status s=new Status();
		s.setId(1);
		user.setStatus(s);
		UserDto udt=new UserDto();
		if(user!=null && !user.getEmail().isEmpty() && user.getEmail()!= null && user.getEmail()!= "" && user.getPassword()!=null && user.getPassword()!="" && !user.getPassword().isEmpty()) {
		if(user.getPassword().equals(user.getConfirmPassword())) {
		try {
			boolean exist= userService.checkExist(user.getEmail());
			if(!exist) {
			BeanUtils.copyProperties(user, u);
			u.setPassword(Converter.Base64Encoder(user.getPassword()));
			User ur = userService.saveUser(u);
			BeanUtils.copyProperties(ur, udt);
			udt.setCreateDate(Converter.dateToStringConverter(ur.getCreateDate()));
			udt.setUpdateDate(Converter.dateToStringConverter(ur.getUpdateDate()));
			res.setMessage("Success!");
			res.setCode(200);
			res.setContent(udt);
			return res;
			}else {
				res.setCode(401);
				res.setMessage("User Already Exist!");
				return res;
			}
		
		}catch (Exception e) {
			e.printStackTrace();
			res.setCode(400);
			res.setMessage("Error!!");
			return res;
		}
		
		}else {
			res.setCode(405);
			res.setMessage("Pasword Missmatch!");
			return res;
		}
	}else {
			res.setCode(404);
			res.setMessage("Mandatory Field Missing!");
			return res;
		}	
	}
	
	/**
	 * @author Ranjeet
	 * @param user
	 * @return
	 */
	@PostMapping("/signin")
	public Response singIn(@RequestBody UserDto user) {
		Response res=new Response();
		if(user!= null && !user.getEmail().isEmpty() && !user.getPassword().isEmpty() && user.getPassword()!="" && user.getEmail()!= "" && user.getEmail()!= null && user.getPassword()!=null) {
		try {
			User u=new User();
			BeanUtils.copyProperties(user, u);
			u.setPassword(Converter.Base64Encoder(user.getPassword()));
			
			User ur= userService.findByCredentials(u);
			if(ur!=null) {
			BeanUtils.copyProperties(ur, user);
			res.setCode(200);
			res.setContent(user);
			res.setMessage("Success!");
			return res;
			}else {
				res.setCode(401);
				res.setMessage("No User Found!!");
				return res;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			res.setCode(400);
			res.setMessage("Error!");
			res.setDescription(e.getMessage());
			return res;
		}
		}else {
			res.setCode(300);
			res.setMessage("Mandatory Field Cannot be blanks!!");
			return res;
		}
	}
	
/**
 * @author Ranjeet
 * @param user
 * @return
 */
	@PostMapping("/reset-password")
	public Response resetPassword(@RequestBody UserDto user) {
		Response res=new Response();
		User u =new User();
		if(user!= null && user.getEmail()!=null && user.getEmail()!= "" && !user.getEmail().isEmpty()) {
		try {
			BeanUtils.copyProperties(user, u);
			User ur =userService.findByEmail(u);
			if(ur== null) {
				res.setCode(300);
				res.setMessage("Given Email is not Resisterd");
				return res;
			}
			ur.setPassword(Converter.Base64Encoder(user.getPassword()));
			User urr =userService.saveUser(ur);
			BeanUtils.copyProperties(urr, user);
			user.setCreateDate(Converter.dateToStringConverter(ur.getCreateDate()));
			user.setUpdateDate(Converter.dateToStringConverter(ur.getUpdateDate()));
			res.setContent(user);
			res.setCode(200);
			res.setMessage("Success!");
			return res;
		}catch (Exception e) {
			e.printStackTrace();
			res.setCode(400);
			res.setMessage("Error!!");
			res.setDescription(e.getMessage());
			return res;
		}
		}else {
			res.setCode(300);
			res.setMessage("Mandatory Field Cannot be blank!!");
			return res;
		}
	}
	
	/**
	 * @author Ranjeet
	 * @param user
	 * @return
	 */
	@PostMapping("/change-password")
	public Response changePassword(@RequestBody UserDto user ) {
		Response res=new Response();
		User u=new User();
		if(user!=null && user.getEmail()!=null && user.getEmail()!="" && !user.getEmail().isEmpty() && user.getOldPassword()!=null && user.getOldPassword()!= "" && !user.getOldPassword().isEmpty() && user.getPassword()!=null && user.getPassword()!="" && !user.getPassword().isEmpty()) {
		try {
			BeanUtils.copyProperties(user, u);
			u.setPassword(Converter.Base64Encoder(user.getOldPassword()));
			User ur=userService.finByEmailAndPasswordAndStatus(u);
			if(ur== null) {
				res.setCode(301);
				res.setMessage("Wrong Credentials!!");
				return res;
			}
			ur.setPassword(Converter.Base64Encoder(user.getPassword()));
			User urr=userService.saveUser(ur);
			BeanUtils.copyProperties(urr, user);
			res.setContent(user);
			res.setCode(200);
			res.setMessage("Success!");
			return res;
		}catch (Exception e) {
			e.printStackTrace();
			res.setCode(400);
			res.setMessage("Error!");
			res.setDescription(e.getMessage());
			return res;
		}
		}else {
			res.setCode(300);
			res.setMessage("Mandatory Field Cannot be blank!!");
			return res;
			
		}
	}
	
}

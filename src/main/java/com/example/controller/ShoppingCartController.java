package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.AddressNotFoundException;
import com.example.exception.DuplicateUserException;
import com.example.exception.ProductNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody User user) {
		
		try {
		    shoppingCartService.saveUser(user);
		    System.out.println(user);
		    return "Order Placed Successfully !!!";
		}
		catch(DuplicateUserException duplicateUserException) {
			return duplicateUserException.getMessage();
		}
	}
	
	@PutMapping("/updateOrder")
	public String updateOrder(@RequestBody User user) {
		
		try {
		    shoppingCartService.updateUser(user);
		    return "Order updated Successfully !!!";
		}
		catch(DuplicateUserException duplicateUserException) {
			return duplicateUserException.getMessage();
		}
	}
	
	@GetMapping("/getcartDetails")
	public List<User> getCartDetails() {
		
		return shoppingCartService.getAllUsers();
	}
	
	@DeleteMapping("/deleteOrder/{userId}")
	public String deleteOrder(@PathVariable Integer userId) {
		
		try {
		    shoppingCartService.deleteUser(userId);
            return "Order Deleted Successfully !!!";
		}
		catch(UserNotFoundException userNotFoundException) {
			return userNotFoundException.getMessage();
		}
	}
	
	@GetMapping("/findOrderByUserID/{userId}")
	public String findOrderByUserId(@PathVariable Integer userId) {
		
		User userObj = shoppingCartService.findUserById(userId);
		return "The User with ID : " + userId + " is displayed below => \n" + userObj;
	}
	
	@GetMapping("/findOrderByUserName/{userName}")
	public String findOrderByUserName(@PathVariable String userName) {
		
		try {
		    List<User> users = shoppingCartService.findUserByUserName(userName);
		    return "The List of Users with given name : " + userName + " is displayed below => \n" + users;
		}
		catch(UserNotFoundException userNotFoundException) {
			return userNotFoundException.getMessage();
		}
	}
	
	@GetMapping("/findOrderByGender/{gender}")
	public String findOrderByGender(@PathVariable String gender) {
		
		try {
		    List<User> users = shoppingCartService.findUserByGender(gender);
		    return "The List of Users with given gender : " + gender + " is displayed below => \n" + users;
		}
		catch(UserNotFoundException userNotFoundException) {
			return userNotFoundException.getMessage();
		}
	}
	
	@GetMapping("/findOrderByAddressCity/{city}")
	public String findOrderByAddressCity(@PathVariable String city) {
		
		try {
		    List<User> users = shoppingCartService.findUserByCity(city);
		    return "The List of Users with given address-city: " + city + " is displayed below => \n" + users;
		}
		catch(AddressNotFoundException addressNotFoundException) {
			return addressNotFoundException.getMessage();
		}
	}
	
	@GetMapping("/findOrderByAddressState/{state}")
	public String findOrderByAddressState(@PathVariable String state) {
		
		try {
		    List<User> users = shoppingCartService.findUserByState(state);
		    return "The List of Users with given address-state : " + state + " is displayed below => \n" + users;
		}
		catch(AddressNotFoundException addressNotFoundException) {
			return addressNotFoundException.getMessage();
		}
	}
	
	@GetMapping("/findOrderByAddressDistrict/{district}")
	public String findOrderByAddressDistrict(@PathVariable String district) {
		
		try {
	    	List<User> users = shoppingCartService.findUserByDistrict(district);
		    return "The List of Users with given address-district: " + district + " is displayed below => \n" + users;
		}
		catch(AddressNotFoundException addressNotFoundException) {
			return addressNotFoundException.getMessage();
		}
	}
	
	@GetMapping("/findOrderByAddressPincode/{pincode}")
	public String findOrderByAddressPincode(@PathVariable String pincode) {
		
		try {
		    List<User> users = shoppingCartService.findUserByPincode(pincode);
		    return "The List of Users with given address-pincode : " + pincode + " is displayed below => \n" + users;
		}
		catch(AddressNotFoundException addressNotFoundException) {
			return addressNotFoundException.getMessage();
		}
    }
	
	@GetMapping("/findOrderByProductName/{productName}")
	public String findOrderByProductName(@PathVariable String productName) {
		
		try {
		    List<User> users = shoppingCartService.findUserByProductName(productName);
		    return "The List of Users with given product name : " + productName + " is displayed below => \n" + users;
		}
		catch(ProductNotFoundException productNotFoundException) {
			return productNotFoundException.getMessage();
		}
	}
	
	@GetMapping("/findOrderByProductPrice/{price}")
	public String findOrderByProductPrice(@PathVariable String price) {
		
		try {
		    List<User> users = shoppingCartService.findUserByProductPrice(price);
		    return "The List of Users with given product price : " + price + " is displayed below => \n" + users;
		}
		catch(ProductNotFoundException productNotFoundException) {
			return productNotFoundException.getMessage();
		}
	}
	
}

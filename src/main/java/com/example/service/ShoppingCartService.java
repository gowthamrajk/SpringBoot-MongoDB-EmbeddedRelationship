package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.AddressNotFoundException;
import com.example.exception.DuplicateUserException;
import com.example.exception.ProductNotFoundException;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	public void saveUser(User user) throws DuplicateUserException {
		
		if(null != findUserById(user.getUserId()))
			throw new DuplicateUserException("User Already Exists !!!");
		else
		    shoppingCartRepository.save(user);
	}
	
	public void updateUser(User user) throws DuplicateUserException {
		
		if(null != findUserById(user.getUserId()))
			throw new DuplicateUserException("User Already Exists !!!");
		else
		    shoppingCartRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		
		return shoppingCartRepository.findAll();
	}
	
	public void deleteUser(Integer userId) throws UserNotFoundException {
		
		if(null != findUserById(userId))
			throw new UserNotFoundException("User Not Found !!!");
		else
		    shoppingCartRepository.deleteById(userId);
	}
	
	public User findUserById(Integer userId) {
		
		return shoppingCartRepository.findByUserId(userId);
	}
	
    public List<User> findUserByUserName(String userName) throws UserNotFoundException {
		
    	List<User> userDetails = shoppingCartRepository.findByUserName(userName);
    	if(userDetails.isEmpty())
    		throw new UserNotFoundException("User with username " + userName + " not found !!!");
    	else
    		return userDetails;
	}
    
    public List<User> findUserByGender(String gender) throws UserNotFoundException {
		
    	List<User> userDetails = shoppingCartRepository.findByGender(gender);
    	if(userDetails.isEmpty())
    		throw new UserNotFoundException("User with gender " + gender + " not found !!!");
    	else
    		return userDetails;
	}
    
    public List<User> findUserByCity(String city) throws AddressNotFoundException {
		
    	List<User> userDetails = shoppingCartRepository.findByCity(city);
    	if(userDetails.isEmpty())
    		throw new AddressNotFoundException("User Address with city : " + city + " not found !!!");
    	else
    		return userDetails;
	}
    
    public List<User> findUserByState(String state) throws AddressNotFoundException {
		
    	List<User> userDetails = shoppingCartRepository.findByState(state);
    	if(userDetails.isEmpty())
    		throw new AddressNotFoundException("User Address with state : " + state + " not found !!!");
    	else
    		return userDetails;
	}
    
    public List<User> findUserByDistrict(String district) throws AddressNotFoundException {
		
    	List<User> userDetails = shoppingCartRepository.findByDistrict(district);
    	if(userDetails.isEmpty())
    		throw new AddressNotFoundException("User Address with district : " + district + " not found !!!");
    	else
    		return userDetails;
	}
    
    public List<User> findUserByPincode(String pincode) throws AddressNotFoundException {
		
    	List<User> userDetails = shoppingCartRepository.findByPincode(pincode);
    	if(userDetails.isEmpty())
    		throw new AddressNotFoundException("User Address with pincode : " + pincode + " not found !!!");
    	else
    		return userDetails;
	}
    
    public List<User> findUserByProductName(String productName) throws ProductNotFoundException {
		
    	List<User> userDetails = shoppingCartRepository.findByProductName(productName);
    	if(userDetails.isEmpty())
    		throw new ProductNotFoundException("User Ordered Product with product name : " + productName + " not found !!!");
    	else
    		return userDetails;
	}
    
    public List<User> findUserByProductPrice(String price) throws ProductNotFoundException {
		
    	List<User> userDetails = shoppingCartRepository.findByPrice(price);
    	if(userDetails.isEmpty())
    		throw new ProductNotFoundException("User Ordered Product with price : " + price + " not found !!!");
    	else
    		return userDetails;
	}

}

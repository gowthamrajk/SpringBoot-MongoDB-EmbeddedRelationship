package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.model.User;

public interface ShoppingCartRepository extends MongoRepository<User, Integer> {
	
	public User findByUserId(Integer userId);
	
	public List<User> findByUserName(String userName);
	
	public List<User> findByGender(String gender);

	@Query("{'Address.city':?0}")
	public List<User> findByCity(String city);
	
	@Query("{'Address.state':?0}")
	public List<User> findByState(String state);
	
	@Query("{'Address.district':?0}")
	public List<User> findByDistrict(String district);
	
	@Query("{'Address.pincode':?0}")
	public List<User> findByPincode(String pincode);
	
	@Query("{'Product.productName':?0}")
	public List<User> findByProductName(String productName);
	
	@Query("{'Product.price':?0}")
	public List<User> findByPrice(String price);

}

package com.tweetapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweetapp.entities.UserModel;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String>{
	
	UserModel findByUsername(String username);
	
	@Query("{'username':{'$regex':'?0','$options':'i'}}")
	List<UserModel> searchByUsername(String username);
}

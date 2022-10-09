package com.example.wiprojsp01.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.wiprojsp01.entity.Users;

public interface UserRepository extends CrudRepository<Users, Integer>{
	@Query(nativeQuery = true, value="SELECT * FROM users WHERE username=:username")
	Users findUser(String username);
	
	@Query(nativeQuery = true, value="SELECT * FROM users WHERE username=:username AND password=:password")
	Users checkUserPassword(String username, String password);
	
	@Modifying
	@Query(nativeQuery = true, value="UPDATE users SET password=:newPassword WHERE username=:username")
	void updatePassword(String username, String newPassword);
}

package com.doodla.engine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.doodla.engine.model.Users;


public interface UserRepository extends JpaRepository<Users, Long> {


	@Query("SELECT u FROM Users u WHERE u.email = :email ")
	Users getFromEmail(@Param("email") String email);
	
	@Query("SELECT u FROM Users u WHERE u.phoneUUID =  :phoneUUID")
	Users getFromPhone(@Param("phoneUUID") String phoneUUID);

	@Query("SELECT u FROM Users u WHERE u.fbUUID =  :fbUUID")
	Users getFromFB(@Param("fbUUID") String fbUUID);

	@Query("SELECT u FROM Users u WHERE u.iosUUID =  :iosUUID")
	Users getFromIOS(@Param("iosUUID") String iosUUID);

	@Query("SELECT u FROM Users u WHERE u.gmailUUID =  :gmailUUID")
	Users getFromGmail(@Param("gmailUUID") String gmailUUID);

	@Query("SELECT count(u) FROM Users u WHERE u.email = :email")
	int countEmail(@Param("email") String email);

}
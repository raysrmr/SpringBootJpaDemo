package com.rays.cts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.rays.cts.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	@Query("SELECT u FROM User u  WHERE u.id=(:id) AND u.pass=(:pass)")
	User findOne(int id, String pass);

}
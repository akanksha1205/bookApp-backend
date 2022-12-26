package com.digital.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digital.user.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{

	@Query(value = "SELECT * FROM digital_book.user_table u where u.user_name = :userName and u.password = :password", nativeQuery = true)
	UserEntity findUser(@Param("userName") String userName, @Param("password") String password);

}

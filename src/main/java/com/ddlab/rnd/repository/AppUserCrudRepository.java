package com.ddlab.rnd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.AppUser;

@Repository
public interface AppUserCrudRepository extends CrudRepository<AppUser, Long> {

	Page<AppUser> findAll(Pageable pageable);
	
	@Query("select u from AppUser u")
	Page<AppUser> getAllAppUsers(Pageable pageable);
	
	@Query("select u from AppUser u")
	Slice<AppUser> getAllSlicedUsers(Pageable pageable);
}

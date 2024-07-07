package com.ddlab.rnd.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.AppUser;

@Repository
public interface AppUserPagingRepository extends PagingAndSortingRepository<AppUser, Long> {
	
}

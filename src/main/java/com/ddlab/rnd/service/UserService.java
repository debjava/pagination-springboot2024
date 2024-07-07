package com.ddlab.rnd.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

import com.ddlab.rnd.entity.AppUser;

public interface UserService {

	void saveAllUsers(List<AppUser> users);

	Page<AppUser> getPaginatedUsersUsingJPARepo(int pageNo, int pageSize);

	Page<AppUser> getPaginatedUsersUsingPaginAndSortingRepo(int pageNo, int pageSize);
	
	Page<AppUser> getPaginatedUsersUsingCrudRepo(int pageNo, int pageSize);
	
	Page<AppUser> getPaginatedUsersUsingCrudRepoCustom(int pageNo, int pageSize);
	
	Slice<AppUser> getSlicedPaginatedUsersUsingCrudRepo(int pageNo, int pageSize);

}

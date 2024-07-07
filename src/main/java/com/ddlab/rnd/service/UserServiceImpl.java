package com.ddlab.rnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.entity.AppUser;
import com.ddlab.rnd.repository.AppUserCrudRepository;
import com.ddlab.rnd.repository.AppUserJPARepository;
import com.ddlab.rnd.repository.AppUserPagingRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private AppUserJPARepository userJpaRepo;
	
	@Autowired
	private AppUserPagingRepository pagingUserRepo;
	
	@Autowired
	private AppUserCrudRepository crudRepo;

	@Override
	public void saveAllUsers(List<AppUser> users) {
		userJpaRepo.saveAll(users);
	}
	
	public Page<AppUser> getPaginatedUsersUsingJPARepo(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return userJpaRepo.findAll(pageable);
    }
	
	
	public Page<AppUser> getPaginatedUsersUsingPaginAndSortingRepo(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return pagingUserRepo.findAll(pageable);
    }
	
	public Page<AppUser> getPaginatedUsersUsingCrudRepo(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return crudRepo.findAll(pageable);
    }
	
	public Page<AppUser> getPaginatedUsersUsingCrudRepoCustom(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return crudRepo.getAllAppUsers(pageable);
    }
	
	public Slice<AppUser> getSlicedPaginatedUsersUsingCrudRepo(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return crudRepo.getAllSlicedUsers(pageable);
    }
}

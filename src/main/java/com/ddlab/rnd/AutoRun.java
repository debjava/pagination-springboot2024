package com.ddlab.rnd;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.entity.AppUser;
import com.ddlab.rnd.service.UserService;

@Component
public class AutoRun {

	@Autowired
	private UserService userService;

	public void persistAllUsers() {
		Instant start = Instant.now();
		List<AppUser> users = new ArrayList<>();
		for (int i = 1001; i < 1500; i++) {
			users.add(new AppUser("Name-" + i, "City-" + i));
		}
		userService.saveAllUsers(users);
		Instant end = Instant.now();
		int timeInNonSecs = Duration.between(start, end).getNano();
		System.out.println("Time Taken to complete in nanoseconds: " + timeInNonSecs);
	}

	public void showJPARepoPaginatedUsers() {
		for (int i = 0; i < 5; i++) {
			Page<AppUser> pagedUsers = userService.getPaginatedUsersUsingJPARepo(i, 10);
			List<AppUser> appUserList = pagedUsers.getContent();
			appUserList.forEach(user -> System.out.println("User: " + user));
		}
	}

	public void showPagingRepoPaginatedUsers() {
		for (int i = 0; i < 5; i++) {
			Page<AppUser> pagedUsers = userService.getPaginatedUsersUsingPaginAndSortingRepo(i, 10);
			List<AppUser> appUserList = pagedUsers.getContent();
			appUserList.forEach(user -> System.out.println("User: " + user));
		}
	}

	public void showCrudRepoPaginatedUsers() {
		for (int i = 0; i < 5; i++) {
			Page<AppUser> pagedUsers = userService.getPaginatedUsersUsingCrudRepo(i, 10);
			List<AppUser> appUserList = pagedUsers.getContent();
			appUserList.forEach(user -> System.out.println("User: " + user));
		}
	}

	public void showCrudRepoPaginatedUsersCustom() {
		for (int i = 0; i < 5; i++) {
			Page<AppUser> pagedUsers = userService.getPaginatedUsersUsingCrudRepoCustom(i, 10);
			List<AppUser> appUserList = pagedUsers.getContent();
			appUserList.forEach(user -> System.out.println("User: " + user));
		}
	}
	
	public void showSlicedCrudRepoPaginatedUsers() {
		for (int i = 0; i < 10; i++) {
			Slice<AppUser> pagedUsers = userService.getSlicedPaginatedUsersUsingCrudRepo(i, 10);
			List<AppUser> appUserList = pagedUsers.getContent();
			appUserList.forEach(user -> System.out.println("User: " + user));
		}
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		System.out.println("Application running ...");
//		persistAllUsers();
//		showJPARepoPaginatedUsers();
//		showPagingRepoPaginatedUsers();
//		showCrudRepoPaginatedUsers();
//		showCrudRepoPaginatedUsersCustom();
		showSlicedCrudRepoPaginatedUsers();
		System.out.println("Database operations completed ...");
	}

}

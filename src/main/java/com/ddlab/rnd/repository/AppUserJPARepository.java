package com.ddlab.rnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.AppUser;

@Repository
public interface AppUserJPARepository extends JpaRepository<AppUser, Long> {

}

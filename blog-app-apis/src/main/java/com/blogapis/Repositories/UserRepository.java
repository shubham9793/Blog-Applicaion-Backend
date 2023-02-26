package com.blogapis.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapis.Entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
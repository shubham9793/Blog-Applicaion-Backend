package com.blogapis.blog.security;

import com.blogapis.Entities.User;
import com.blogapis.Exceptions.ResourseNotFoundException;
import com.blogapis.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Load user from database by userName
       User user =  this.userRepository.findByEmail(username)
                .orElseThrow(() -> new ResourseNotFoundException("User","Email :" +username,0 ));
        return user;
    }
}

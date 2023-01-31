package com.zzpzaf.restapidemo.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.zzpzaf.restapidemo.Repositories.UsersRepo;
import com.zzpzaf.restapidemo.dataObjects.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user;
        org.springframework.security.core.userdetails.User springUser = null;

        user = repo.getUserByName(username);

        if (user != null) {

            springUser = new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    user.getUserAuthorities());
            return springUser;
        } else {
            //throw new UsernameNotFoundException(String.format("Username not found"));
            return null;

        }
        //return null;
    }
 
    






}

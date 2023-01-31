package com.zzpzaf.restapidemo.Controllers;

import java.util.List;

import com.zzpzaf.restapidemo.Repositories.UsersRepo;
import com.zzpzaf.restapidemo.dataObjects.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersRepo repo; 

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers() {

        try {
        
            return new ResponseEntity<>(repo.getUsers(), HttpStatus.OK);    

        } catch (Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

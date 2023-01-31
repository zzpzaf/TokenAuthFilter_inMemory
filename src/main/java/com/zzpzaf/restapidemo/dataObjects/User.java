package com.zzpzaf.restapidemo.dataObjects;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;

public class User {
    
        private String userName;
        private String userPassword;
        private List<GrantedAuthority> userAuthorities;
       
        public User() {
        }
  
        public User(String userName, String userPassword, List<GrantedAuthority> userAuthorities) {
            this.userName = userName;
            this.userPassword = userPassword;
            this.userAuthorities = userAuthorities;
        }

        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }
        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public List<GrantedAuthority> getUserAuthorities() {
            return userAuthorities;
        }
        public void setUserAuthorities(List<GrantedAuthority> userAuthorities) {
            this.userAuthorities = userAuthorities;
        }

}

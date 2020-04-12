package com.twb.loadfile.sec;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

    private String username;
    private String password;

//    public AuthRequest(String username, String password){
//        this.username = username;
//        this.password = password;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
}

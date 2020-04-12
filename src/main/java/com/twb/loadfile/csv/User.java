package com.twb.loadfile.csv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "USERS")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String username;
    private String phoneNumber;
    private String address;

//    public User(){}
//
//    public User(int id, String username, String phoneNumber, String address) {
//        this.id = id;
//        this.username = username;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public User(String username) {
//        this.username = username;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}


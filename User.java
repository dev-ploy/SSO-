package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "users")
public class User{

    @Id
    private Long id;
    private String login;
//    private String email;
//    private String username;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login=login;
    }
//    public String getEmail(){
//        return email;
//    }
//    public void setEmail(String email){
//        this.email=email;
//    }
//    public String getUsername(){
//        return username;
//    }
//    public void setUsername(String username){
//        this.username=username;
//    }
}

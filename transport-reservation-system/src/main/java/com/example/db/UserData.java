package com.example.db;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Created by ayesh on 9/9/16.
 */
@Table(name="user")
@Entity
public class UserData {
    @GeneratedValue
    private long u_id;

    @Id
    private String u_name;

    private String name;
    private String email;
    private String password;

    public long getu_id(){
        return u_id;
    }
    public void setu_id(int s){
        this.u_id = s;
    }
    public String getu_name(){
        return u_name;
    }
    public void setu_name(String s){
        this.u_name = s;
    }
    public String getName(){
        return name;
    }
    public void setName(String s){
        this.name = s;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String e){
        this.email = e;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String s){
        this.password = s;
    }
}

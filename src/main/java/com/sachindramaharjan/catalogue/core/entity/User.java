package com.sachindramaharjan.catalogue.core.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sachindra.maharjan on 4/13/16.
 */
@Entity
@Table(name= "TBL_USER")
public class User implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name="USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ACTIVATE_FL")
    private boolean activate_fl;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;

    public User(){}

    public User(String username, String password, String email, boolean activate_fl) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.activate_fl = activate_fl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public boolean isActivate_fl() {
        return activate_fl;
    }

    public void setActivate_fl(boolean activate_fl) {
        this.activate_fl = activate_fl;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

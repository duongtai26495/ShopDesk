package com.shopdesk.hitech.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "active", nullable = false)
    private int active;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne()
    @JoinColumn(name = "role_id",referencedColumnName = "role_id",insertable = false)
    private Role role;

    @Column(name = "joined_at",updatable = false)
    private String joinedAt;

    @Column(name = "last_edit_at")
    private String lastEditAt;

    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(String joinedAt) {
        this.joinedAt = joinedAt;
    }

    public String getLastEditAt() {
        return lastEditAt;
    }

    public void setLastEditAt(String lastEditAt) {
        this.lastEditAt = lastEditAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

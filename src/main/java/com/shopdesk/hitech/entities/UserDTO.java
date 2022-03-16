package com.shopdesk.hitech.entities;

public class UserDTO {

    private Long Id;

    private String fullName;

    private String username;

    private int active;

    private String email;

    private Role role;

    private String joinedAt;

    private String lastEditAt;

    public UserDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}

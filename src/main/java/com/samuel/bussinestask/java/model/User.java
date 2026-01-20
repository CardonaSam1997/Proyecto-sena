package com.samuel.bussinestask.java.model;
import java.sql.Date;

public class User  {  
    private int id;
    private String userName;
    private String password;
    private String email;
    private Role role;

    private boolean authentication;
    private boolean enable;
    private boolean completed;
    private Date createdAt;
    private Date updatedAt;
    
    public User(){        
    }

    public User(int id, String userName, String password, String email, Role role, boolean authentication, boolean enable, boolean completed, Date createdAt, Date updatedAt) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
        this.authentication = authentication;
        this.enable = enable;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
        
    
    public User(String userName, String password,String email, Role role){ 
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
        this.authentication = false;
        this.enable = false;
        this.completed = false;        
        createdAt = new Date(System.currentTimeMillis());        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }        
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isAuthentication() {
        return authentication;
    }

    public void setAuthentication(boolean authentication) {
        this.authentication = authentication;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getCreateAt() {
        return createdAt;
    }

    public void setCreateAt(Date createAt) {
        this.createdAt = createAt;
    }

    public Date getUpdateAt() {
        return updatedAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updatedAt = updateAt;
    }   

    @Override
    public String toString() {
        return "" + "id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", role=" + role + ", authentication=" + authentication + ", enable=" + enable + ", completed=" + completed + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '\n';
    }               
}
package com.sport.app.controller.application_user;

import com.backend.repository.entity.ApplicationUser;

public class ApplicationUserDTO {

    public ApplicationUserDTO(){};

    public ApplicationUserDTO(ApplicationUser applicationUser) {
        setEmail(applicationUser.getEmail());
        setFacebook(applicationUser.getFacebook());
        setInstagram(applicationUser.getInstagram());
        setPhone(applicationUser.getPhone());
        setUsername(applicationUser.getUsername());
        setId(applicationUser.getId());
    }

    private int id;
    private String username;
    private String email;
    private String phone;
    private String instagram;
    private String facebook;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

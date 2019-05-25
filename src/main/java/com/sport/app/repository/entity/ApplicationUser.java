package com.sport.app.repository.entity;

import com.sport.app.controller.application_user.ApplicationUserDTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "application_user")
public class ApplicationUser {

    public ApplicationUser(){};

    public ApplicationUser(ApplicationUserDTO dto){
        setEmail(dto.getEmail());
        setFacebook(dto.getFacebook());
        setInstagram(dto.getInstagram());
        setPhone(dto.getPhone());
        setUsername(dto.getUsername());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "instagram")
    private String instagram;
    @Column(name = "facebook")
    private String facebook;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicationUser", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Event> events;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Sale")
public class Sale {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String songTitle;

    private double songPrice;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;

    public Sale() {
    }

    public Sale(String songTitle, double songPrice) {
        this.songTitle = songTitle;
        this.songPrice = songPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public double getSongPrice() {
        return songPrice;
    }

    public void setSongPrice(double songPrice) {
        this.songPrice = songPrice;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

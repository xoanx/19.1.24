package com.example.demo.driver;

import jakarta.persistence.*;

import java.awt.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "rating")
    private double rating;
    @Column(columnDefinition = "Point")
    private Point location;
    public Driver() {
    }

    public Driver(Long id, String name, int age, double rating,Point location) {
        this.id = id;
        this.name=name;
        this.age=age;
        this.rating=rating;
        this.location=location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}


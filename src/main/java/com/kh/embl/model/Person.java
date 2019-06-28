package com.kh.embl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


import java.util.Arrays;
import java.util.List;


@Entity
public class Person {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String favouriteColor;
    private String hobby[];

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }


    public Person(String firstName, String lastName, int age, String favouriteColor, String[] hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.favouriteColor = favouriteColor;
        this.hobby = hobby;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavouriteColor() {
        return favouriteColor;
    }

    public void setFavouriteColor(String favouriteColor) {
        this.favouriteColor = favouriteColor;
    }

    @Override
    public String toString() {
        return "Person{" +

                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", favouriteColor='" + favouriteColor + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }
}
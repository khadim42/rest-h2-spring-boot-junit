package com.kh.embl.service;

import java.util.List;
import java.util.Optional;

import com.kh.embl.model.Person;

public interface PersonSevice {

    public List<Person> getPersons();

    public Optional<Person> getPersonById(int personId);

    public Person addNewPerson(Person emp);

    public Person updatePerson(Person emp);

    public void deletePersonById(int empid);

    public void deleteAllPersons();

}
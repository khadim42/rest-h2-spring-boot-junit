package com.kh.embl.service;

import java.util.List;
import java.util.Optional;

import com.kh.embl.dao.PersonRepositoryDao;
import com.kh.embl.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonSevice {

    @Autowired
    PersonRepositoryDao personRepositoryDao;

    @Override
    public List<Person> getPersons() {
        return personRepositoryDao.findAll();
    }

    @Override
    public Optional<Person> getPersonById(int personId) {
        return personRepositoryDao.findById(personId);
    }

    @Override
    public Person addNewPerson(Person person) {
        return personRepositoryDao.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepositoryDao.save(person);
    }

    @Override
    public void deletePersonById(int personId) {
        personRepositoryDao.deleteById(personId);
    }

    @Override
    public void deleteAllPersons() {
        personRepositoryDao.deleteAll();
    }
}
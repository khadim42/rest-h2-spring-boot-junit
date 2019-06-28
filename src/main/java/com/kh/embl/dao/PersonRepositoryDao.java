package com.kh.embl.dao;

import com.kh.embl.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositoryDao extends JpaRepository<Person, Integer> {

}
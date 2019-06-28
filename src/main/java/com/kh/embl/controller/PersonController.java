package com.kh.embl.controller;

import java.util.Optional;

import com.kh.embl.beans.ResultBean;
import com.kh.embl.model.Person;
import com.kh.embl.service.PersonSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonSevice personSevice;


	@RequestMapping(value= "/all", method= RequestMethod.GET)
	public ResponseEntity<ResultBean> getPersons() {
		System.out.println(this.getClass().getSimpleName() + " - Get all persons personSevice is invoked.");

		return new ResponseEntity<>(new ResultBean(personSevice.getPersons()), HttpStatus.OK);
	}

	@RequestMapping(value= "/{id}", method= RequestMethod.GET)
	public Person getPersonById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get person details by id is invoked.");

		Optional<Person> person =  personSevice.getPersonById(id);
		if(!person.isPresent())
			throw new Exception("Could not find person with id- " + id);

		return person.get();
	}

	@RequestMapping(value= "/add", method= RequestMethod.POST)
	public Person createPerson(@RequestBody Person newPerson) {
		System.out.println(this.getClass().getSimpleName() + " - Create new person method is invoked.");
		return personSevice.addNewPerson(newPerson);
	}

	@RequestMapping(value= "/update/{id}", method= RequestMethod.PUT)
	public Person updatePerson(@RequestBody Person updPerson, @PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update person details by id is invoked.");

		Optional<Person> person =  personSevice.getPersonById(id);
		if (!person.isPresent())
			throw new Exception("Could not find person with id- " + id);

		updPerson.setId(id);
		return personSevice.updatePerson(updPerson);
	}

	@RequestMapping(value= "/delete/{id}", method= RequestMethod.DELETE)
	public void deletePersonById(@PathVariable int id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete person by id is invoked.");

		Optional<Person> emp =  personSevice.getPersonById(id);
		if(!emp.isPresent())
			throw new Exception("Could not find person with id- " + id);

		personSevice.deletePersonById(id);
	}

	@RequestMapping(value= "/deleteall", method= RequestMethod.DELETE)
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all persons is invoked.");
		personSevice.deleteAllPersons();
	}
}
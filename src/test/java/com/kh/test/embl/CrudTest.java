package com.kh.test.embl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.kh.embl.Myapplication;
import com.kh.embl.model.Person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Myapplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CrudTest {


    @Autowired
    private TestRestTemplate restTemplate;


    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }


    @Test
    public void contextLoads() {


    }

    @Before
    public void setup(){
        // Set up database
        System.out.println("<<<< -- DUMMY DATA FIRST --- >>>");

        for (int i = 1; i <= 2; i++) {

            String hobbies[] = {"Programming", "puzzles"};
            Person person = new Person("Khadim", "Hussain", 29, "Green", hobbies);
            ResponseEntity<Person> postResponse = restTemplate.postForEntity(getRootUrl() + "/persons/add", person, Person.class);
            System.out.println("INSERTED :: " + postResponse.getBody());
        }
    }

    @Test
    public void testGetAllPersons() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/persons/all",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
//        Logger.getLogger(this.getClass().getName()).log(Level.INFO,response.getBody());
        System.out.println("ALL Persons: \n "+response.getBody());
    }


    @Test
    public void testCreatePerson() {
        String hobbies[] = {"Programming", "puzzles"};
        Person person = new Person("Khadim", "Hussain", 29, "Green", hobbies);


        ResponseEntity<Person> postResponse = restTemplate.postForEntity(getRootUrl() + "/persons/add", person, Person.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Person Created Successfully: \n "+postResponse.getBody());
    }

    @Test
    public void testGetPersonById() {
        Person person = restTemplate.getForObject(getRootUrl() + "/persons/1", Person.class);

        System.out.println("Person Retrieved Successfully: \n "+person);
        assertNotNull(person);
    }


    @Test
    public void testUpdatePost() {
        int id = 1;
        Person person = restTemplate.getForObject(getRootUrl() + "/persons/" + id, Person.class);
        person.setFirstName("test1");
        person.setLastName("test2");

        restTemplate.put(getRootUrl() + "/persons/update/" + id, person);

        Person updatedPerson = restTemplate.getForObject(getRootUrl() + "/persons/" + id, Person.class);
        System.out.println("Person Updated Successfully: \n "+updatedPerson);
        assertNotNull(updatedPerson);
    }

    @Test
    public void testDeletePost() {
        int id = 2;
        Person person = restTemplate.getForObject(getRootUrl() + "/persons/" + id, Person.class);
        assertNotNull(person);

        restTemplate.delete(getRootUrl() + "/persons/" + id);

        try {
            person = restTemplate.getForObject(getRootUrl() + "/persons/" + id, Person.class);
            System.out.println("Person Deleted Successfully: \n "+person);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}

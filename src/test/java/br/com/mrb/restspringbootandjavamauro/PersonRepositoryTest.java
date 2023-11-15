package br.com.mrb.restspringbootandjavamauro;

import br.com.mrb.restspringbootandjavamauro.model.Person;
import br.com.mrb.restspringbootandjavamauro.repositorys.PersonRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    Person person ;

    @BeforeEach
    public void setup() {
        person =  new Person("Mauro","Braga","Rio de Janeiro - Brasil","Male","mrb0305@gmail.com");
    }

    @DisplayName("JUnit test for Given Person Object when Save then Return Saved Person")
    @Test
    void testGivenPersonObject_whenSave_thenReturnSavedPerson() {
        //Given / Arange

        //When / Act
        var personSaved = personRepository.save(person);

        //Then / Assert
        assertNotNull(personSaved);
        assertTrue(personSaved.getId() > 0);
    }

    @DisplayName("JUnit test for Given Person List when findAll then Return Person List")
    @Test
    void testGivenPersonList_whenFindAll_thenReturnPersonList() {
        //Given / Arange
        var person1 = new Person("Oscar","Braga","Rio de Janeiro - Brasil","Male","oscar@gmail.com");

        personRepository.save(person);
        personRepository.save(person1);

        //When / Act
        var personList = personRepository.findAll();

        //Then / Assert
        assertNotNull(personList);
        assertEquals(2,personList.size());
    }

    @DisplayName("JUnit test for Given Person Object when findByID then Return Person Object")
    @Test
    void testGivenPersonObject_whenFindByID_thenReturnPersonObject() {
        //Given / Arange
        personRepository.save(person);
        //When / Act
        var personSaved = personRepository.findById(person.getId()).get();
        //Then / Assert
        assertNotNull(personSaved);
        assertEquals(person.getId(),personSaved.getId());
    }

    @DisplayName("JUnit test for Given Person Object when findByEmail then Return Person Object")
    @Test
    void testGivenPersonObject_whenFindByEmail_thenReturnPersonObject() {
        //Given / Arange
        personRepository.save(person);
        //When / Act
        var personSaved = personRepository.findByEmail(person.getEmail()).get();
        //Then / Assert
        assertNotNull(personSaved);
        assertEquals(person.getId(),personSaved.getId());
    }

    @DisplayName("JUnit test for Given Person Object when Update Person then Return Updated Person Object")
    @Test
    void testGivenPersonObject_whenUpdatePerson_thenReturnUpdatedPersonObject() {
        //Given / Arange
        personRepository.save(person);
        //When / Act
        var personSaved = personRepository.findById(person.getId()).get();
        personSaved.setFirstName("Leonardo");
        personSaved.setEmail("leonardo@erudio.com.br");

        var updatedPerson = personRepository.save(personSaved);

        //Then / Assert
        assertNotNull(updatedPerson);
        assertEquals("Leonardo", updatedPerson.getFirstName());
        assertEquals("leonardo@erudio.com.br", updatedPerson.getEmail());
    }

    @DisplayName("JUnit test for Given Person Object when Delete then Remove Person")
    @Test
    void testGivenPersonObject_whenDelete_thenRemovePerson(){
        //Given / Arange
        personRepository.save(person);
        //When / Act
        personRepository.deleteById(person.getId());
        Optional<Person> personOptional = personRepository.findById(person.getId());
        //Then / Assert
        assertTrue(personOptional.isEmpty());
    }

    @DisplayName("JUnit test for Given firstName and lastName when findJPQL then Return Person Object")
    @Test
    void testGivenFirstNameAndLastName_whenFindJPQL_thenReturnPersonObject() {

        // Given / Arrange
        personRepository.save(person);

        String firstName = "Mauro";
        String lastName = "Braga";

        // When / Act
        Person savedPerson = personRepository.findByJPQL(firstName, lastName);

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(firstName, savedPerson.getFirstName());
        assertEquals(lastName, savedPerson.getLastName());
    }

    @DisplayName("JUnit test for Given firstName and lastName when findByJPQLNamedParameters then Return Person Object")
    @Test
    void testGivenFirstNameAndLastName_whenFindByJPQLNamedParameters_thenReturnPersonObject() {

        // Given / Arrange
        personRepository.save(person);

        String firstName = "Mauro";
        String lastName = "Braga";

        // When / Act
        Person savedPerson = personRepository.findByJPQLNamedParameters(firstName, lastName);

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(firstName, savedPerson.getFirstName());
        assertEquals(lastName, savedPerson.getLastName());
    }

    @DisplayName("JUnit test for Given firstName and lastName when findByNativeSQL then Return Person Object")
    @Test
    void testGivenFirstNameAndLastName_whenFindByNativeSQL_thenReturnPersonObject() {

        // Given / Arrange
        personRepository.save(person);

        String firstName = "Mauro";
        String lastName = "Braga";

        // When / Act
        Person savedPerson = personRepository.findByNativeSQL(firstName, lastName);

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(firstName, savedPerson.getFirstName());
        assertEquals(lastName, savedPerson.getLastName());
    }

    @DisplayName("JUnit test for Given firstName and lastName when findByNativeSQLwithNamedParameters then Return Person Object")
    @Test
    void testGivenFirstNameAndLastName_whenFindByNativeSQLwithNamedParameters_thenReturnPersonObject() {

        // Given / Arrange
        personRepository.save(person);

        String firstName = "Mauro";
        String lastName = "Braga";

        // When / Act
        Person savedPerson = personRepository.findByNativeSQLwithNamedParameters(firstName, lastName);

        // Then / Assert
        assertNotNull(savedPerson);
        assertEquals(firstName, savedPerson.getFirstName());
        assertEquals(lastName, savedPerson.getLastName());
    }
}

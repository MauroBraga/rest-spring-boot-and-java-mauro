package br.com.mrb.restspringbootandjavamauro;

import br.com.mrb.restspringbootandjavamauro.model.Person;
import br.com.mrb.restspringbootandjavamauro.repositorys.PersonRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;
    @BeforeEach
    public void setup() {}

    @DisplayName("JUnit test for Given Person Object when Save then Return Saved Person")
    @Test
    void testGivenPersonObject_whenSave_thenReturnSavedPerson() {
        //Given / Arange
        var person = new Person("Mauro","Braga","Rio de Janeiro - Brasil","Male","mrb0305@gmail.com");
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
        var person = new Person("Mauro","Braga","Rio de Janeiro - Brasil","Male","mrb0305@gmail.com");
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
        var person = new Person("Mauro","Braga","Rio de Janeiro - Brasil","Male","mrb0305@gmail.com");
        personRepository.save(person);
        //When / Act
        var personSaved = personRepository.findById(person.getId()).get();
        //Then / Assert
        assertNotNull(personSaved);
        assertEquals(person.getId(),personSaved.getId());
    }
}

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
}

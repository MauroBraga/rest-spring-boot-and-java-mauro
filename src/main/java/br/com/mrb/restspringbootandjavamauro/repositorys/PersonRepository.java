package br.com.mrb.restspringbootandjavamauro.repositorys;

import br.com.mrb.restspringbootandjavamauro.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long> {
}

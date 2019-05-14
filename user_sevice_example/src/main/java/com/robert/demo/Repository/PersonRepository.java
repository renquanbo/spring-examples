package com.robert.demo.Repository;

import com.robert.demo.dataobject.Person;
import org.springframework.data.repository.CrudRepository;

import javax.naming.Name;

public interface PersonRepository extends CrudRepository<Person, Name>{

}

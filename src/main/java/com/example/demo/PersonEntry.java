package com.example.demo;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface PersonEntry extends MongoRepository<Person,String>{
      Person findByEmail(String email); 
}

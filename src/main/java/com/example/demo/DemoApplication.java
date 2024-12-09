package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;
// import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


@RestController
@RequestMapping("/person")
class PersonControl{
	@Autowired
	PersonServ s;
	
	@PostMapping("/post")
	public Person addEntry(@RequestBody Person person){
		return s.saveEntry(person);
	}

	@GetMapping("/get")
	public List<Person> getData(){
		return s.getData();
	}

	@GetMapping("get/email")
	public Person getPerson(){
		return s.getPersonByEmail("arpi2733@gmail.com");
	}
}

@RestController
@RequestMapping("/item")
class ItemControl{
	@Autowired
	ItemServ s;

	@PostMapping("/post")
	public Item addItem(@RequestBody Item itm){
		s.saveItem(itm);
		return itm;
	}

	@GetMapping("/get")
	public List<Item> allItems(){
		return s.getAllItems();
	}
}


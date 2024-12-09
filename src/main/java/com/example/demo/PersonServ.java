package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class PersonServ {

    @Autowired
    private PersonEntry entry;

    private final PasswordEncoder encode=new BCryptPasswordEncoder();

    public Person saveEntry(Person p){
        p.setPassword(encode.encode(p.getPassword()));
        p.setRole("USER");
        return entry.save(p);
    }

    public List<Person> getData(){
        return entry.findAll();
    }

    public Person getPersonByEmail(String s){
        return entry.findByEmail(s);
    }
}

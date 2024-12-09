package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
@Component
public class UserDetailAuth implements UserDetailsService {

    @Autowired
    private PersonEntry personEntry;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
        Person person = personEntry.findByEmail(username);

        if(person==null){
            throw new UsernameNotFoundException("User not found");
        }
        return  org.springframework.security.core.userdetails.User.builder()
        .username(person.getEmail())
        .password(person.getPassword())
        .roles(person.getRole().toArray(new String[0]))
        .build();
    }
    
}
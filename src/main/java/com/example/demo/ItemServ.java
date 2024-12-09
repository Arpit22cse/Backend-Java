package com.example.demo;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
//import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;



@Component

public class ItemServ {
    
    @Autowired
    ItemEntry im;
    @Autowired
    PersonServ ps;

    
    public Item saveItem(Item itm){
        itm.setDate(LocalDateTime.now());
        im.save(itm);
        return itm;
    }

    
    public List<Item> getAllItems(){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        ps.getPersonByEmail(auth.getName());
        return im.findAll();
    }
}

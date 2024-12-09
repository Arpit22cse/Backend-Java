package com.example.demo;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Item")
public class Item {
    private ObjectId id;
    private LocalDateTime date;
    private String type;
    private String data;
    private long amount;


    public void setId(ObjectId ob){
        this.id=ob;
    }
    public void setData(String data){
        this.data=data;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setDate(LocalDateTime lT){
        this.date=lT;
    }
    public void setAmount(long amount){
        this.amount=amount;
    }

    

    public ObjectId getId(){
        return this.id;
    }
    public String getData(){
        return this.data;
    }
    public String getType(){
        return this.type;
    }
    public LocalDateTime date(){
        return this.date;
    }
    public long getAmount(){
        return this.amount;
    }

    
}




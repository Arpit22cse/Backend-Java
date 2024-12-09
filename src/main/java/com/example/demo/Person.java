package com.example.demo;


//import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Person")
public class Person{
	@Id
	private ObjectId id;
	private String email;
	private String password;
	private List<String> role=new ArrayList<>();
	@DBRef
	List<Item> red=new ArrayList<>();
	@DBRef
	List<Item> green=new ArrayList<>();
	@DBRef
	List<Item> blue=new ArrayList<>();


	public void setId(ObjectId a){
	 	this.id=a;
	}

	public void setEmail(String a){
		this.email=a;
	}

	public void setPassword(String a){
		this.password=a;
	}

	public String getPassword(){
		return this.password;
	}
	
	public ObjectId getId(){
	    return this.id;
	}

	public String getEmail(){
		return this.email;
	}
	 
	public void setRole(String a){
		role.add(a);
	}

	public List<String> getRole(){
		return this.role;
	}	

}



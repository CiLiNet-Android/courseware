package com.cilinet.dbStorage.bean;

public class Person {
	public Integer personId;
	public String personName;
	public Integer personAge;
	
	public Person(Integer personId,String personName,Integer personAge){
		this.personId = personId;
		this.personName = personName;
		this.personAge = personAge;
	}
	
	public Person(){}

	public Person(String personName,Integer personAge){
		this.personName = personName;
		this.personAge = personAge;
	}
	
	public String toString(){
		return "personName: " + personName + " @ personAge: " + personAge;
	}
}

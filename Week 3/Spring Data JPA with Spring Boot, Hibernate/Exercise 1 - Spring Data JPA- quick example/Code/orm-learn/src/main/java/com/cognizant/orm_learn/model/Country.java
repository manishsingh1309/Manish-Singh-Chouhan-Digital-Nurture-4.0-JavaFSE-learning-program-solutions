package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

@Entity
@Table(name="country")
public class Country {

    @Id
    @Column(name="co_code")
    private String code; 

    @Column(name="co_name")
    private String name;

    public String getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public void setCode(String code){
        this.code = code;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Country Code: "+ this.code + ", Country Name: " + this.name; 
    }
    
}

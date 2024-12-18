package com.example.demo;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Students")
public class Students {
	@Field("Sem")
	private String sem;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	Students(){
		System.out.print("The Students Class Have Been Initialized");
	}
	
    @Field("Registernumber")
     private Long registerNumber;		
    
    public Students(Map<String, Object> student_Details , Long Registernumber) {
	
		Student_Details = student_Details;
		this.registerNumber = Registernumber;
	}
	private Map<String , Object> Student_Details;
    
    
   

	@Override
	public String toString() {
		return "Students [sem=" + sem + ", name=" + name + ", registerNumber=" + registerNumber + ", Student_Details="
				+ Student_Details + "]";
	}

	public void setStudent_Details(Map<String , Object> Student_Details ) {
    	this.Student_Details = Student_Details;
    }
    
   

	public Map<String , Object> getStudent_Details(){
    	return this.Student_Details;
    }
   
    public void setRegisternumber(Long Registernumber) {
    	this.registerNumber = Registernumber;
    }
   public Long getRegisternumber() {
	   return this.registerNumber;
   }
}

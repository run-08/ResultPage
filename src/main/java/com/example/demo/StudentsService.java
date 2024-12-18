package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {
  @Autowired
  Studentrepository repo;
  
  
  public  Map<String , Students> AddMark(Map<String , Object> reqobject){
	  
	  Long Registernumber =Long.parseLong(reqobject.get("registernumber").toString());
	  Map<String , Object> student = null;
	  
	  if(repo.findByRegisterNumber(Registernumber) != null) student = UpdateMark(reqobject);
	  
	  else student = (Map<String , Object>)reqobject.get("student");
	  
	 Students students = new Students();
	  
	 students.setName(reqobject.get("name").toString());
	 
	 students.setRegisternumber(Registernumber);
	 
	 students.setStudent_Details(student);
	 
	 students.setSem(reqobject.get("sem").toString());
	 
	 repo.save(students);
	  

	  
	  return GetMark(Registernumber);
  }
   
  public Map<String , Object> UpdateMark(Map<String , Object> reqobject ) {
	  
	  Students student = repo.findByRegisterNumber(Long.parseLong(reqobject.get("registernumber").toString()));
	  
	  //delete The Previous Document
	  
	  DeleteMark(Long.parseLong(reqobject.get("registernumber").toString()));
	  
	  Map<String , Object> student_details = student.getStudent_Details();
	  
	  
	  student_details.putAll((Map<String , Object>)reqobject.get("student"));
	  
	  return student_details;
	  
	 
  }
  
  public Map<String , Object>DeleteMark(Long id) {
	  
	  repo.deleteByRegisterNumber(id);
	  
	  HashMap response = new HashMap<>();
	  
	  response.put("Deleted",new String("The Mark is Deleted Successfully"));
	  
	  return response;
  }
  public Map<String , Students> GetMark(Long id) {
//	  System.out.print(id+"\n");
//	  System.out.print(repo.findByRegisterNumber(id)+"\n");
	  
	  Map<String , Students> response  = new HashMap<>();
	  
	  response.put("Student", repo.findByRegisterNumber(id));
	  
	  return response;
  }
}

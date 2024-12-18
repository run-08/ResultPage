package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class End_pointController {
	
	@Autowired
	StudentsService service;
	
	@Autowired
	Studentrepository repo;
  
	@GetMapping("/")
	@ResponseBody
	public String SayHello() {
		System.out.print("Hello!");
		return "Welcomt to My Result Page ";
	}

	@ResponseBody
	@GetMapping("/getresult{Registernumber}")
	public Map<String , Object> getresult (@PathVariable("Registernumber") Long id){ 
		System.out.print(id+"\n");
		if(repo.findByRegisterNumber(id) == null) {
			System.out.print("InValid Id");
			return null;
		}
		Students student = repo.findByRegisterNumber(id);
	    Map<String , Object> response = student.getStudent_Details();
	    response.put("name",student.getName());
	    response.put("registernumber", id);
	    response.put("sem",student.getSem());
		return student.getStudent_Details();
	}
	@GetMapping("/Staffs_mark_register")
	public String StaffsMarkRegister(){ 
		return "Markregistry.html" ;
	}
	
	@PostMapping("/saveMark")
	public ResponseEntity<Map<String, Students>> saveMark(@RequestBody Map<String , Object>  reqobject){
		System.out.print(reqobject);
		return ResponseEntity.status(200).body(service.AddMark(reqobject));
	}
}

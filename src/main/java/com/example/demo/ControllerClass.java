package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControllerClass {

	
	
	@Autowired
	Feignclient feignclient;
	
	@GetMapping("/GetResultPage")
	public String GetResultPage() {
		System.out.print(false+"\n");
		return "resultpage.html";
	}
	
	@GetMapping("/GetMarks{Registernumber}")
	public ResponseEntity<Map<String , Object>> getresultpage(@PathVariable("Registernumber") Long id){
		 Map<String , Object> response  = feignclient.getresult(id);
		 System.out.print(response);
		 return ResponseEntity.ok(response);
	}
	
}

package com.example.demo;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="STUDENTRESULTPAGE")
public interface Feignclient {

	@GetMapping("/getresult{Registernumber}")
	public Map<String , Object>getresult(@PathVariable("Registernumber") Long id);
}

package com.example.demo;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;

@Configuration
@LoadBalancerClient(name="STUDENTRESULTPAGE" ,configuration=RandomBalancing.class)
public class Configurer {
	@LoadBalanced
	@Bean
	public Feign.Builder feignbuilder(){
		return Feign.builder();
	}

}

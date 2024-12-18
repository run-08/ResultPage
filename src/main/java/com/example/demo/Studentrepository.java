package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepository extends MongoRepository<Students , Long>{
	 @Query("{ 'Registernumber' : ?0 }")
    Students findByRegisterNumber(Long registernumber);
	 void deleteByRegisterNumber(Long registernumber);
};

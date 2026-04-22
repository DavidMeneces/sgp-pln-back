package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IngredientModelRepositoryTest {

	@Autowired
	IngredientModelRepository repository;


	@Test
	void findAll() {
		var result = repository.findAll(10,0);
		System.out.println("result = " + result);
	}
}

package edu.nur.nurtricenter.mealplans.presentation.controller;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.nutricionist.GetNutritionistsCommand;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.NutricionistModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/meal-plans/nutritionists")
public class MealPlanNutritionistsController {

	private final Pipeline pipeline;

	public MealPlanNutritionistsController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@GetMapping("")
	public ResultWithValue<List<NutricionistModel>> get(@RequestParam(required = false, defaultValue = "0") int page,
														@RequestParam(required = false, defaultValue = "10") int size) {
		var command = new GetNutritionistsCommand(page, size);
		log.info("[GET] get {}", command);
		return command.execute(pipeline);
	}
}

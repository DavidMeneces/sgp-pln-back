package edu.nur.nurtricenter.mealplans.presentation.controller;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.subscription.GetSubscriptionTypesCommand;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.SubscriptionTypeModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/meal-plans/subscription-types")
public class MealPlanSubscriptionTypesController {

	private final Pipeline pipeline;

	public MealPlanSubscriptionTypesController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@GetMapping("")
	public ResultWithValue<List<SubscriptionTypeModel>> get(@RequestParam(required = false, defaultValue = "0") int page,
															@RequestParam(required = false, defaultValue = "10") int size) {
		var command = new GetSubscriptionTypesCommand(page, size);
		log.info("[GET] get {}", command);
		return command.execute(pipeline);
	}
}

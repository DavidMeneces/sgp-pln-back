package edu.nur.nurtricenter.mealplans.presentation.controller;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.ingredient.CreateIngredientCommand;
import edu.nur.nurtricenter.mealplans.application.ingredient.GetIngredientCommand;
import edu.nur.nurtricenter.mealplans.application.ingredient.IngredientDto;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/ingredients")
public class IngredientController {

	private final Pipeline pipeline;

	public IngredientController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@PostMapping("")
	public ResultWithValue<UUID> create(@RequestBody CreateIngredientCommand command) {
		log.info("[POST] create {}", command);
		return command.execute(pipeline);
	}

	@GetMapping("/{id}")
	public ResultWithValue<IngredientDto> getById(@PathVariable UUID id) {
		GetIngredientCommand command = new GetIngredientCommand(id);
		log.info("[GET] getById {}", command);
		return command.execute(pipeline);
	}
}

package edu.nur.nurtricenter.mealplans.presentation.controller;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.ingredient.CreateIngredientCommand;
import edu.nur.nurtricenter.mealplans.application.ingredient.GetIngredientByIdCommand;
import edu.nur.nurtricenter.mealplans.application.ingredient.GetIngredientsCommand;
import edu.nur.nurtricenter.mealplans.application.ingredient.IngredientDto;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.List;
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

	@GetMapping("")
	public ResultWithValue<List<IngredientDto>> get(@RequestParam(required = false, defaultValue = "0") int page,
													@RequestParam(required = false, defaultValue = "10") int size) {
		GetIngredientsCommand command = new GetIngredientsCommand(page, size);
		log.info("[GET] get {}", command);
		return command.execute(pipeline);
	}

	@GetMapping("/{id}")
	public ResultWithValue<IngredientDto> getById(@PathVariable UUID id) {
		GetIngredientByIdCommand command = new GetIngredientByIdCommand(id);
		log.info("[GET] getById {}", command);
		return command.execute(pipeline);
	}
}

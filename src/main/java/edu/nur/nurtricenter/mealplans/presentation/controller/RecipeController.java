package edu.nur.nurtricenter.mealplans.presentation.controller;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.recipe.CreateRecipeCommand;
import edu.nur.nurtricenter.mealplans.application.recipe.GetRecipeByIdCommand;
import edu.nur.nurtricenter.mealplans.application.recipe.GetRecipesCommand;
import edu.nur.nurtricenter.mealplans.application.recipe.RecipeDto;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;

import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/recipes")
public class RecipeController {

	private final Pipeline pipeline;

	public RecipeController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@PostMapping("")
	public ResultWithValue<UUID> create(@RequestBody CreateRecipeCommand command) {
		log.info("[POST] create {}", command);
		return command.execute(pipeline);
	}

	@GetMapping("")
	public ResultWithValue<List<RecipeDto>> get(@RequestParam(required = false, defaultValue = "0") int page,
												@RequestParam(required = false, defaultValue = "10") int size) {
		GetRecipesCommand command = new GetRecipesCommand(page, size);
		log.info("[GET] get {}", command);
		return command.execute(pipeline);
	}

	@GetMapping("/{id}")
	public ResultWithValue<RecipeDto> getById(@PathVariable UUID id) {
		GetRecipeByIdCommand command = new GetRecipeByIdCommand(id);
		log.info("[GET] getById {}", command);
		return command.execute(pipeline);
	}
}

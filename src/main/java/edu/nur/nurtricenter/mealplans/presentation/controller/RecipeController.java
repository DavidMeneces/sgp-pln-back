package edu.nur.nurtricenter.mealplans.presentation.controller;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.recipe.CreateRecipeCommand;
import edu.nur.nurtricenter.mealplans.application.recipe.GetRecipeCommand;
import edu.nur.nurtricenter.mealplans.application.recipe.RecipeDto;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final Pipeline pipeline;

    public RecipeController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("")
    public ResultWithValue<UUID> create(@RequestBody CreateRecipeCommand command) {
        return command.execute(pipeline);
    }

    @GetMapping("/{id}")
    public ResultWithValue<RecipeDto> getById(@PathVariable UUID id) {
        GetRecipeCommand command = new GetRecipeCommand(id);
        return command.execute(pipeline);
    }

}

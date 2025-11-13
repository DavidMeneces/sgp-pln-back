package edu.nur.nurtricenter.mealplans.presentation.controllers;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.ingredient.CreateIngredientCommand;
import edu.nur.nurtricenter.mealplans.application.recipe.GetRecipeCommand;
import edu.nur.nurtricenter.mealplans.application.recipe.RecipeDto;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final Pipeline pipeline;

    public IngredientController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("")
    public ResultWithValue<UUID> get(@RequestBody CreateIngredientCommand command) {
        return command.execute(pipeline);
    }

}

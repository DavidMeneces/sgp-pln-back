package edu.nur.nurtricenter.mealplans.presentation.controllers;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.recipe.GetRecipeCommand;
import edu.nur.nurtricenter.mealplans.application.recipe.RecipeDto;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.application.mealplan.CreateMealPlanCommand;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/meal-plan")
public class MealPlanController {

    private final Pipeline pipeline;

    public MealPlanController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @GetMapping("/{id}")
    public ResultWithValue<RecipeDto> get(@PathVariable UUID id) {
        GetRecipeCommand command = new GetRecipeCommand(id);
        return command.execute(pipeline);
    }

    @PostMapping("")
    public ResultWithValue<UUID> add(@RequestBody CreateMealPlanCommand command) {
        return command.execute(pipeline);
    }

}

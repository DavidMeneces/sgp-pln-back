package edu.nur.nurtricenter.mealplans.presentation.controllers;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.mealplan.*;
import edu.nur.nurtricenter.mealplans.application.recipe.GetRecipeCommand;
import edu.nur.nurtricenter.mealplans.application.recipe.RecipeDto;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/meal-plan")
public class MealPlanController {

    private final Pipeline pipeline;

    public MealPlanController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("")
    public ResultWithValue<UUID> create(@RequestBody CreateMealPlanCommand command) {
        return command.execute(pipeline);
    }

    @GetMapping("/{id}")
    public ResultWithValue<MealPlanDto> getById(@PathVariable UUID id) {
        GetMealPlanCommand command = new GetMealPlanCommand(id);
        return command.execute(pipeline);
    }

    @PatchMapping("/{id}")
    public ResultWithValue<Boolean> updateById(@PathVariable UUID id) {
        UpdateMealPlanCommand command = new UpdateMealPlanCommand(id);
        return command.execute(pipeline);
    }

    @PatchMapping("/{id}/cancel")
    public ResultWithValue<Boolean> cancelById(@PathVariable UUID id) {
        CancelMealPlanCommand command = new CancelMealPlanCommand(id);
        return command.execute(pipeline);
    }

}

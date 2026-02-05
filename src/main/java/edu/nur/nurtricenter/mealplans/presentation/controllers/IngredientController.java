package edu.nur.nurtricenter.mealplans.presentation.controllers;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.ingredient.CreateIngredientCommand;
import edu.nur.nurtricenter.mealplans.application.ingredient.GetIngredientCommand;
import edu.nur.nurtricenter.mealplans.application.ingredient.IngredientDto;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final Pipeline pipeline;

    public IngredientController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("")
    public ResultWithValue<UUID> create(@RequestBody CreateIngredientCommand command) {
        return command.execute(pipeline);
    }

    @GetMapping("/{id}")
    public ResultWithValue<IngredientDto> getById(@PathVariable UUID id) {
        GetIngredientCommand command = new GetIngredientCommand(id);
        return command.execute(pipeline);
    }
}

package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.ingredient.GetIngredientCommand;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class CancelMealPlanHandlerTest {

    private final Pipeline pipeline;

    @Inject
    CancelMealPlanHandlerTest(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Test
    void handle() {
        var id = UUID.fromString("1b0296ba-d08b-4dbd-952e-3893db79c7e6");
        var request = new CancelMealPlanCommand(id);
        var response = request.execute(pipeline);
        System.out.println("response = " + response);
        Assertions.assertNotNull(response.getValue());
    }
}
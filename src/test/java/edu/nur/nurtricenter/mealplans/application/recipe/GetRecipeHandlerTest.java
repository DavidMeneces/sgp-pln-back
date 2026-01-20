package edu.nur.nurtricenter.mealplans.application.recipe;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.application.ingredient.GetIngredientCommand;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class GetRecipeHandlerTest {

    private final Pipeline pipeline;

    @Inject
    GetRecipeHandlerTest(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Test
    void handle() {
        var id = UUID.fromString("331a6eed-fa94-4137-a4e1-0c60b186f338");
        var request = new GetRecipeCommand(id);
        var response = request.execute(pipeline);
        Assertions.assertNotNull(response.getValue());
    }
}
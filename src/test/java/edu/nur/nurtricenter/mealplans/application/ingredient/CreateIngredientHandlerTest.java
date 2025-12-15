package edu.nur.nurtricenter.mealplans.application.ingredient;

import an.awesome.pipelinr.Pipeline;
import edu.nur.nurtricenter.mealplans.domain.shared.UnitMeasureEnum;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class CreateIngredientHandlerTest {

    private final Pipeline pipeline;

    @Inject
    public CreateIngredientHandlerTest(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Test
    void createIngredientValid() {
        String name = "Almendras";
        String description = "Almendras";
        UnitMeasureEnum unitMeasure = UnitMeasureEnum.GRAM;
        BigDecimal caloriesPerGram = BigDecimal.valueOf(150L);
        var request = new CreateIngredientCommand(name, description, unitMeasure, caloriesPerGram);
        var response = request.execute(pipeline);
        Assertions.assertNotNull(response.getValue());
    }
}
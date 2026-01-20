package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpdateMealPlanHandlerTest {

    private final Pipeline pipeline;

    @Inject
    UpdateMealPlanHandlerTest(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Test
    void handle() {
    }
}
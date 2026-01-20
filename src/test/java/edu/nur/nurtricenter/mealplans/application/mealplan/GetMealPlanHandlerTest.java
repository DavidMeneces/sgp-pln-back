package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Pipeline;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetMealPlanHandlerTest {

    private final Pipeline pipeline;

    @Inject
    GetMealPlanHandlerTest(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Test
    void handle() {
    }
}
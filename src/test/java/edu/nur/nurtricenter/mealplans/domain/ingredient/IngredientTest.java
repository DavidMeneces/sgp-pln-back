package edu.nur.nurtricenter.mealplans.domain.ingredient;

import edu.nur.nurtricenter.mealplans.domain.shared.UnitMeasureEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IngredientTest {

    @Test
    void createIngredientValid() {
        //Arrange
        var id = UUID.randomUUID();
        var name = "Test Name";
        var description = "Test Description";
        var unitMeasure = UnitMeasureEnum.GRAM;
        var caloriesPerGram = BigDecimal.ONE;
        //Act
        var ingredient = Ingredient.create(id, name, description, unitMeasure, caloriesPerGram);
        //Assert
        Assertions.assertEquals(id, ingredient.getId());
        Assertions.assertEquals(name, ingredient.getName());
        Assertions.assertEquals(description, ingredient.getDescription());
        Assertions.assertEquals(unitMeasure, ingredient.getUnitMeasure());
        Assertions.assertEquals(caloriesPerGram, ingredient.getCaloriesPerGram());
    }

    @Test
    void createIngredientExceptionId() {
        //Arrange
        UUID id = null;
        String name = "Test Name";
        String description = "Test Description";
        UnitMeasureEnum unitMeasure = UnitMeasureEnum.GRAM;
        BigDecimal caloriesPerGram = BigDecimal.ONE;
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Ingredient.create(id, name, description, unitMeasure, caloriesPerGram)
        );
        //Assert
        Assertions.assertEquals("id cannot be null", exception.getMessage());

    }

    @Test
    void createIngredientExceptionName() {
        //Arrange
        UUID id = UUID.randomUUID();
        String name = null;
        String description = "Test Description";
        UnitMeasureEnum unitMeasure = UnitMeasureEnum.GRAM;
        BigDecimal caloriesPerGram = BigDecimal.ONE;
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Ingredient.create(id, name, description, unitMeasure, caloriesPerGram)
        );
        //Assert
        Assertions.assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @Test
    void createIngredientExceptionCaloriesZero() {
        //Arrange
        UUID id = UUID.randomUUID();
        String name = "Test Name";
        String description = "Test Description";
        UnitMeasureEnum unitMeasure = UnitMeasureEnum.GRAM;
        BigDecimal caloriesPerGram = BigDecimal.valueOf(-1L);
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Ingredient.create(id, name, description, unitMeasure, caloriesPerGram)
        );
        //Assert
        Assertions.assertEquals("caloriesPerGram cannot be null or menor than zero", exception.getMessage());
    }
}
package edu.nur.nurtricenter.mealplans.domain.recipe;

import edu.nur.nurtricenter.mealplans.domain.ingredient.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeTest {

    @Test
    void createRecipeValid() {
        //Arrange
        UUID id = UUID.randomUUID();
        String name = "Name Test";
        String description = "Desctiption Test";
        String instructions = "Instructions Test";
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<RecipeIngredient> ingredients = Arrays.asList(
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 1),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 2),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 3));
        //Act
        Recipe recipe = Recipe.create(id, name, description, instructions, totalCalories, ingredients);
        //Assert
        Assertions.assertEquals(id, recipe.getId());
        Assertions.assertEquals(name, recipe.getName());
        Assertions.assertEquals(description, recipe.getDescription());
        Assertions.assertEquals(instructions, recipe.getInstructions());
        Assertions.assertEquals(totalCalories, recipe.getTotalCalories());
        Assertions.assertEquals(ingredients, recipe.getIngredients());
    }

    @Test
    void createRecipeExceptionId() {
        //Arrange
        UUID id = null;
        String name = "Name Test";
        String description = "Desctiption Test";
        String instructions = "Instructions Test";
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<RecipeIngredient> ingredients = Arrays.asList(
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 1),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 2),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 3));
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Recipe.create(id, name, description, instructions, totalCalories, ingredients));
        //Assert
        Assertions.assertEquals("Id cannot be null", exception.getMessage());
    }

    @Test
    void createRecipeExceptionName() {
        //Arrange
        UUID id = UUID.randomUUID();
        String name = null;
        String description = "Desctiption Test";
        String instructions = "Instructions Test";
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<RecipeIngredient> ingredients = Arrays.asList(
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 1),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 2),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 3));
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Recipe.create(id, name, description, instructions, totalCalories, ingredients));
        //Assert
        Assertions.assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @Test
    void createRecipeExceptionDescription() {
        //Arrange
        UUID id = UUID.randomUUID();
        String name = "Name Test";
        String description = null;
        String instructions = "Instructions Test";
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<RecipeIngredient> ingredients = Arrays.asList(
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 1),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 2),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 3));
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Recipe.create(id, name, description, instructions, totalCalories, ingredients));
        //Assert
        Assertions.assertEquals("description cannot be null or empty", exception.getMessage());
    }

    @Test
    void createRecipeExceptionInstructions() {
        //Arrange
        UUID id = UUID.randomUUID();
        String name = "Name Test";
        String description = "Description Test";
        String instructions = null;
        BigDecimal totalCalories = BigDecimal.valueOf(0L);
        List<RecipeIngredient> ingredients = Arrays.asList(
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 1),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 2),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 3));
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Recipe.create(id, name, description, instructions, totalCalories, ingredients));
        //Assert
        Assertions.assertEquals("instructions cannot be null or empty", exception.getMessage());
    }

    @Test
    void createRecipeExceptionTotalCalories() {
        //Arrange
        UUID id = UUID.randomUUID();
        String name = "Name Test";
        String description = "Description Test";
        String instructions = "Instructions Test";
        BigDecimal totalCalories = BigDecimal.valueOf(0L);
        List<RecipeIngredient> ingredients = Arrays.asList(
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 1),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 2),
                RecipeIngredient.crear(UUID.randomUUID(), UUID.randomUUID(), 3));
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Recipe.create(id, name, description, instructions, totalCalories, ingredients));
        //Assert
        Assertions.assertEquals("totalCalories cannot be null or minor than or equal zero", exception.getMessage());
    }

    @Test
    void createRecipeExceptionIngredients() {
        //Arrange
        UUID id = UUID.randomUUID();
        String name = "Name Test";
        String description = "Description Test";
        String instructions = "Instructions Test";
        BigDecimal totalCalories = BigDecimal.valueOf(100L);
        List<RecipeIngredient> ingredients = null;
        //Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Recipe.create(id, name, description, instructions, totalCalories, ingredients));
        //Assert
        Assertions.assertEquals("ingredients cannot be null or empty", exception.getMessage());
    }

}
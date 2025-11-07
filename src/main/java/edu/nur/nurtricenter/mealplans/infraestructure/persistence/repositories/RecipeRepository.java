package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.domain.recipe.IRecipeRepository;
import edu.nur.nurtricenter.mealplans.domain.recipe.Recipe;
import edu.nur.nurtricenter.mealplans.domain.recipe.RecipeIngredient;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.RecipeIngredientModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.RecipeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RecipeRepository implements IRecipeRepository {

    @Autowired
    private RecipeModelRepository repository;
    @Autowired
    private RecipeIngredientModelRepository recipeIngredientModelRepository;

    @Override
    public Recipe getById(UUID id, boolean readOnly) {
        RecipeModel model = repository.findById(id).get();
        List<RecipeIngredientModel> ingredientModel = recipeIngredientModelRepository.findAllByIdRecipe(id);
        return new Recipe(model.getId(), model.getName(), model.getDescription(), model.getInstructions(),
                model.getTotalCalories(), ingredientModel.stream().map(ingredient -> new RecipeIngredient(ingredient.getId(), ingredient.getIdIngredient(), ingredient.getQuantity())).toList());
    }

    @Override
    public UUID add(Recipe entity) {
        RecipeModel model = RecipeModel.buildModel(entity);
        repository.save(model);
        saveIngredients(entity.getId(), entity.getIngredients());
        return entity.getId();
    }

    private void saveIngredients(UUID id, List<RecipeIngredient> ingredients) {
        for (RecipeIngredient ingredient : ingredients) {
            RecipeIngredientModel model = RecipeIngredientModel.buildModel(id, ingredient);
            recipeIngredientModelRepository.save(model);
        }
    }

    @Override
    public boolean existById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existById(UUID id, String status) {
        return false;
    }
}

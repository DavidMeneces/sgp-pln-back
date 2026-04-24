package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.domain.recipe.IRecipeRepository;
import edu.nur.nurtricenter.mealplans.domain.recipe.Recipe;
import edu.nur.nurtricenter.mealplans.domain.recipe.RecipeIngredient;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.RecipeIngredientModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.RecipeModel;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeRepository implements IRecipeRepository {

	@Autowired
	private RecipeModelRepository repository;
	@Autowired
	private RecipeIngredientModelRepository recipeIngredientModelRepository;

	@Override
	public List<Recipe> get(Integer page, Integer size) {
		var models = repository.findAll(size, page);
		var ingredientModels = recipeIngredientModelRepository.findAllByIdRecipe(models.stream().map(RecipeModel::getId).toList()).stream()
			.collect(Collectors.groupingBy(RecipeIngredientModel::getIdRecipe));
		return models.stream().map(model -> toEntity(model, ingredientModels.get(model.getId()))).toList();
	}

	@Override
	public Recipe getById(UUID id, boolean readOnly) {
		RecipeModel model = repository.findById(id).get();
		List<RecipeIngredientModel> ingredientModel = recipeIngredientModelRepository.findAllByIdRecipe(id);
		return toEntity(model, ingredientModel);
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

	private Recipe toEntity(RecipeModel model, List<RecipeIngredientModel> ingredientModel) {
		return new Recipe(
			model.getId(),
			model.getName(),
			model.getDescription(),
			model.getInstructions(),
			model.getTotalCalories(),
			ingredientModel.stream()
				.map(
					ingredient ->
						new RecipeIngredient(
							ingredient.getId(),
							ingredient.getIdIngredient(),
							ingredient.getQuantity()))
				.toList(),
			model.getTransaction(),
			model.getStatus(),
			model.getCreatedBy(),
			model.getCreatedAt());
	}

}

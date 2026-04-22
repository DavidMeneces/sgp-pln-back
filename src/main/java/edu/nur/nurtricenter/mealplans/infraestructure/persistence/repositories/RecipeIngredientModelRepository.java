package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.RecipeIngredientModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecipeIngredientModelRepository
		extends CrudRepository<RecipeIngredientModel, UUID> {

	@Query("""
			SELECT rim
			FROM RecipeIngredientModel rim
			WHERE rim.idRecipe = :idRecipe""")
	List<RecipeIngredientModel> findAllByIdRecipe(@Param("idRecipe") UUID idRecipe);

	@Query("""
			SELECT rim
			FROM RecipeIngredientModel rim
			WHERE rim.idRecipe in (:idRecipes)""")
	List<RecipeIngredientModel> findAllByIdRecipe(@Param("idRecipes") List<UUID> idRecipes);
}

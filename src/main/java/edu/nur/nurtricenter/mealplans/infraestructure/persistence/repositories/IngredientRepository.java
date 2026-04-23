package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.domain.ingredient.IIngredientRepository;
import edu.nur.nurtricenter.mealplans.domain.ingredient.Ingredient;
import edu.nur.nurtricenter.mealplans.domain.shared.UnitMeasureEnum;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.IngredientModel;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientRepository implements IIngredientRepository {

	@Autowired
	private IngredientModelRepository repository;

	@Override
	public List<Ingredient> get(Integer page, Integer size) {
		var models = repository.findAll(size, page);
		return models.stream().map(this::toEntity).toList();
	}

	@Override
	public Ingredient getById(UUID id, boolean readOnly) {
		IngredientModel model = repository.findById(id).get();
		return toEntity(model);
	}

	@Override
	public boolean existById(UUID id) {
		return repository.existsById(id);
	}

	@Override
	public UUID add(Ingredient entity) {
		IngredientModel model = IngredientModel.buildModel(entity);
		System.out.println("model = " + model);
		repository.save(model);
		return entity.getId();
	}

	private Ingredient toEntity(IngredientModel model) {
		return new Ingredient(
			model.getId(),
			model.getName(),
			model.getDescription(),
			UnitMeasureEnum.valueOf(model.getUnitMeasure()),
			model.getCaloriesPerGram());
	}
}

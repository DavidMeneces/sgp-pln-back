package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.domain.ingredient.IIngredientRepository;
import edu.nur.nurtricenter.mealplans.domain.ingredient.Ingredient;
import edu.nur.nurtricenter.mealplans.domain.shared.UnitMeasureEnum;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.IngredientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class IngredientRepository implements IIngredientRepository {

    @Autowired
    private IngredientModelRepository repository;

    @Override
    public Ingredient getById(UUID id, boolean readOnly) {
        IngredientModel model = repository.findById(id).get();
        return new Ingredient(model.getId(), model.getName(), model.getDescription(), UnitMeasureEnum.valueOf(model.getUnitMeasure()),
                model.getCaloriesPerGram());
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
}

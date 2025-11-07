package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.domain.ingredient.IIngredientRepository;
import edu.nur.nurtricenter.mealplans.domain.ingredient.Ingredient;
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
        return null;
    }

    @Override
    public UUID add(Ingredient entity) {
        IngredientModel model = IngredientModel.buildModel(entity);
        System.out.println("model = " + model);
        repository.save(model);
        return entity.getId();
    }
}

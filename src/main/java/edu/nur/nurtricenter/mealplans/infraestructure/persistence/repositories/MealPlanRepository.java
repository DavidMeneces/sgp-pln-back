package edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories;

import edu.nur.nurtricenter.mealplans.domain.mealplan.*;
import edu.nur.nurtricenter.mealplans.domain.shared.TimeFoodEnum;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.domainModel.TransaccionEstadoModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.MealPlanDayModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.MealPlanModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.TimeFoodModel;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.TimeFoodRecipeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class MealPlanRepository implements IMealPlanRepository {

    @Autowired
    MealPlanModelRepository repository;
    @Autowired
    MealPlanDayModelRepository mealPlanDayModelRepository;
    @Autowired
    TimeFoodModelRepository timeFoodModelRepository;
    @Autowired
    TimeFoodRecipeModelRepository timeFoodRecipeModelRepository;

    @Override
    public MealPlan getById(UUID id, boolean readOnly) {
        MealPlanModel mealPlanModel = repository.findById(id).get();
        List<MealPlanDayModel> mealPlanDayModels = mealPlanDayModelRepository.findAllByIdMealPlan(id);
        List<TimeFoodModel> timeFoodModels = timeFoodModelRepository.findAllByIdMealPlanDay(mealPlanDayModels.stream().map(MealPlanDayModel::getId).toList());
        List<TimeFoodRecipeModel> timeFoodRecipeModels = timeFoodRecipeModelRepository.findAllByIdTimeFood(timeFoodModels.stream().map(TimeFoodModel::getId).toList());
        //Mapper By IdMealPlanDay
        Map<UUID, List<TimeFoodModel>> timeFoodModelMap = timeFoodModels.stream()
                .collect(Collectors.groupingBy(TimeFoodModel::getIdMealPlanDay));
        //Mapper By IdTimeFood
        Map<UUID, List<TimeFoodRecipeModel>> timeFoodRecipeModelMap = timeFoodRecipeModels.stream()
                .collect(Collectors.groupingBy(TimeFoodRecipeModel::getIdTimeFood));
        //Builder MealPlanDays
        List<MealPlanDay> mealPlanDays = mealPlanDayModels.stream()
                .map(model -> new MealPlanDay(model.getId(), model.getDay(), toTimeFood(timeFoodModelMap.get(model.getId()), timeFoodRecipeModelMap)))
                .toList();
        return new MealPlan(mealPlanModel.getId(), mealPlanModel.getIdNutricionist(), mealPlanModel.getIdPatient(),
                mealPlanModel.getIdAppointment(), mealPlanModel.getIdSubscription(), mealPlanModel.getTotalDays(),
                mealPlanModel.getStarDate(), mealPlanModel.getEndDate(), mealPlanModel.getTotalCalories(),
                mealPlanDays);
    }

    private List<TimeFood> toTimeFood(List<TimeFoodModel> timeFoodModels, Map<UUID, List<TimeFoodRecipeModel>> timeFoodRecipeModelMap) {
        return timeFoodModels != null ? timeFoodModels.stream()
                .map(model -> new TimeFood(model.getId(), TimeFoodEnum.valueOf(model.getType()), model.getOrder(),
                        toTimeFoodRecipe(timeFoodRecipeModelMap.get(model.getId())))
                ).toList() : null;
    }

    private List<TimeFoodRecipe> toTimeFoodRecipe(List<TimeFoodRecipeModel> timeFoodRecipeModels) {
        return timeFoodRecipeModels != null ? timeFoodRecipeModels.stream()
                .map(model -> new TimeFoodRecipe(model.getId(), model.getIdRecipe(), model.getPortion())).toList() : null;
    }

    @Override
    public boolean existById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existById(UUID id, String status) {
        return repository.existById(id, status);
    }

    @Override
    public void cancelById(UUID id) {
        MealPlanModel model = repository.findById(id).get();
        TransaccionEstadoModel transaccion = TransaccionEstadoModel.CANCELAR;
        model.setTransaccion(transaccion.name());
        model.setEstado(transaccion.getEstado());
        model.setUsuarioModificacion("sgp-pln");
        model.setFechaModificacion(LocalDateTime.now());
        repository.save(model);
    }

    @Override
    public UUID add(MealPlan entity) {
        var model = MealPlanModel.buildModel(entity);
        repository.save(model);
        addMealPlanDay(model.getId(), entity.getMealPlanDays());
        return entity.getId();
    }

    protected void addMealPlanDay(UUID id, List<MealPlanDay> mealPlanDays) {
        for (MealPlanDay mealPlanDay : mealPlanDays) {
            MealPlanDayModel model = MealPlanDayModel.buildModel(id, mealPlanDay);
            mealPlanDayModelRepository.save(model);
            addTimeFood(model.getId(), mealPlanDay.getTimeFoods());
        }
    }

    protected void addTimeFood(UUID id, List<TimeFood> timeFoods) {
        for (TimeFood timeFood : timeFoods) {
            TimeFoodModel model = TimeFoodModel.buildModel(id, timeFood);
            timeFoodModelRepository.save(model);
            addTimeFoodRecipe(model.getId(), timeFood.getRecipes());
        }
    }

    protected void addTimeFoodRecipe(UUID id, List<TimeFoodRecipe> timeFoodsRecipes) {
        for (TimeFoodRecipe timeFoodRecipe : timeFoodsRecipes) {
            TimeFoodRecipeModel model = TimeFoodRecipeModel.buildModel(id, timeFoodRecipe);
            timeFoodRecipeModelRepository.save(model);
        }
    }

    @Override
    public void update(MealPlan item) {

    }

    @Override
    public void delete(UUID id) {

    }
}

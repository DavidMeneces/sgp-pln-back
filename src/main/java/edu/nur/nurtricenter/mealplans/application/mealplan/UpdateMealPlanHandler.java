package edu.nur.nurtricenter.mealplans.application.mealplan;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.DomainException;
import edu.nur.nurtricenter.mealplans.core.results.Error;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.domain.mealplan.*;
import edu.nur.nurtricenter.mealplans.domain.mealplan.event.MealPlanUpdatedEvent;
import edu.nur.nurtricenter.mealplans.domain.recipe.IRecipeRepository;
import edu.nur.nurtricenter.mealplans.infraestructure.UnitOfWork;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.AppointmentModelRepository;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.NutricionistModelRepository;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.PatientModelRepository;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories.SuscriptionTypeModelRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UpdateMealPlanHandler
	implements Command.Handler<UpdateMealPlanCommand, ResultWithValue<Boolean>> {

	private final IMealPlanRepository repository;
	private final IRecipeRepository recipeRepository;
	private final PatientModelRepository patientModelRepository;
	private final NutricionistModelRepository nutricionistModelRepository;
	private final SuscriptionTypeModelRepository suscriptionTypeModelRepository;
	private final AppointmentModelRepository appointmentModelRepository;
	private final UnitOfWork unitOfWork;

	public UpdateMealPlanHandler(
		IMealPlanRepository repository,
		IRecipeRepository recipeRepository,
		PatientModelRepository patientModelRepository,
		NutricionistModelRepository nutricionistModelRepository,
		SuscriptionTypeModelRepository suscriptionTypeModelRepository,
		AppointmentModelRepository appointmentModelRepository,
		UnitOfWork unitOfWork) {
		this.repository = repository;
		this.recipeRepository = recipeRepository;
		this.patientModelRepository = patientModelRepository;
		this.nutricionistModelRepository = nutricionistModelRepository;
		this.suscriptionTypeModelRepository = suscriptionTypeModelRepository;
		this.appointmentModelRepository = appointmentModelRepository;
		this.unitOfWork = unitOfWork;
	}

	@Override
	public ResultWithValue<Boolean> handle(UpdateMealPlanCommand command) {
		MealPlan mealPlan;
		try {
			if (!repository.existById(command.id(), "CREADO")) {
				return ResultWithValue.validationFailure(
					Error.notFound("NotFound", "Not found meal-plan", command.id().toString()));
			}
			if (!nutricionistModelRepository.existsById(command.idNutricionist())) {
				return ResultWithValue.validationFailure(
					Error.notFound(
						"NotFound",
						"Not found nutritionist",
						command.idNutricionist().toString()));
			}
			if (!patientModelRepository.existsById(command.idPatient())) {
				return ResultWithValue.validationFailure(
					Error.notFound(
						"NotFound", "Not found patient", command.idPatient().toString()));
			}
			if (!appointmentModelRepository.existsById(command.idAppointment())) {
				return ResultWithValue.validationFailure(
					Error.notFound(
						"NotFound",
						"Not found appointment",
						command.idPatient().toString()));
			}
			if (!suscriptionTypeModelRepository.existsById(command.idSubscription())) {
				return ResultWithValue.validationFailure(
					Error.notFound(
						"NotFound",
						"Not found subscription type",
						command.idPatient().toString()));
			}
			List<MealPlanDay> mealPlanDayList = buildMealPlanDay(command.mealPlanDays());
			mealPlan =
				MealPlan.create(
					command.id(),
					command.idNutricionist(),
					command.idPatient(),
					command.idAppointment(),
					command.idSubscription(),
					command.totalDays(),
					command.starDate(),
					command.endDate(),
					command.totalCalories(),
					mealPlanDayList);
		} catch (DomainException ex) {
			return ResultWithValue.validationFailure(ex.getError());
		}
		repository.update(mealPlan);
		mealPlan.addDomainEvent(
			new MealPlanUpdatedEvent(
				mealPlan.getId(),
				mealPlan.getIdNutricionist(),
				mealPlan.getIdPatient(),
				mealPlan.getIdAppointment(),
				mealPlan.getIdSubscription(),
				mealPlan.getTotalDays(),
				mealPlan.getStarDate(),
				mealPlan.getEndDate(),
				mealPlan.getTotalCalories(),
				mealPlan.getMealPlanDays()));
		this.unitOfWork.commitAsync(mealPlan);
		return ResultWithValue.success(Boolean.TRUE);
	}

	private List<MealPlanDay> buildMealPlanDay(
		List<UpdateMealPlanCommand.MealPlanDayCommad> requestList) {
		return (requestList != null)
			? requestList.stream()
			.map(
				request ->
					MealPlanDay.create(
						UUID.randomUUID(),
						request.day(),
						buildTimeFood(request.timeFoods())))
			.toList()
			: new ArrayList<>();
	}

	private List<TimeFood> buildTimeFood(List<UpdateMealPlanCommand.TimeFoodCommad> requestList) {
		return (requestList != null)
			? requestList.stream()
			.map(
				request ->
					TimeFood.create(
						UUID.randomUUID(),
						request.type(),
						request.order(),
						buildTimeFoodRecipe(request.recipes())))
			.toList()
			: new ArrayList<>();
	}

	private List<TimeFoodRecipe> buildTimeFoodRecipe(
		List<UpdateMealPlanCommand.TimeFoodRecipeCommand> requestList) {
		return (requestList != null)
			? requestList.stream()
			.map(
				request -> {
					if (!recipeRepository.existById(request.idRecipe())) {
						throw new DomainException(
							Error.notFound(
								"NotFound",
								"Not found recipe",
								request.idRecipe().toString()));
					}
					return TimeFoodRecipe.create(
						UUID.randomUUID(),
						request.idRecipe(),
						request.portion());
				})
			.toList()
			: new ArrayList<>();
	}
}

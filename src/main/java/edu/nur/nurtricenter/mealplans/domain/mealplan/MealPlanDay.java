package edu.nur.nurtricenter.mealplans.domain.mealplan;

import edu.nur.nurtricenter.mealplans.core.abstractions.Entity;
import java.util.List;
import java.util.UUID;

public class MealPlanDay extends Entity {
	private Integer day;
	private List<TimeFood> timeFoods;

	private MealPlanDay() {
		super();
	}

	public MealPlanDay(UUID id, Integer day, List<TimeFood> timeFoods) {
		super(id);
		this.day = day;
		this.timeFoods = timeFoods;
	}

	public static MealPlanDay create(UUID id, Integer day, List<TimeFood> timeFoods) {
		if (id == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (day == null) {
			throw new IllegalArgumentException("day cannot be null");
		}
		if (timeFoods == null || timeFoods.isEmpty()) {
			throw new IllegalArgumentException("timeFoods cannot be null or empty");
		}
		return new MealPlanDay(id, day, timeFoods);
	}

	public Integer getDay() {
		return day;
	}

	public List<TimeFood> getTimeFoods() {
		return timeFoods;
	}
}

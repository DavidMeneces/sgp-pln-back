package edu.nur.nurtricenter.mealplans.presentation.controller;

import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InformationController {

	@GetMapping("")
	public ResultWithValue<String> getInfo() {
		Package pkg = getClass().getPackage();
		return ResultWithValue.success(pkg.getImplementationVersion());
	}
}

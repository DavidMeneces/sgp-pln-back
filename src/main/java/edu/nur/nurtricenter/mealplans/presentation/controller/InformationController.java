package edu.nur.nurtricenter.mealplans.presentation.controller;

import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/info")
public class InformationController {

	@GetMapping("")
	public ResultWithValue<String> getInfo() {
		log.info("[GET] getInfo");
		Package pkg = getClass().getPackage();
		return ResultWithValue.success(pkg.getImplementationVersion());
	}
}

package edu.nur.nurtricenter.mealplans.application.patient;

import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.core.results.ResultWithValue;
import edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel.PatientModel;

import java.util.List;

public record GetPatientsCommand(Integer page, Integer size) implements Command<ResultWithValue<List<PatientModel>>> {}

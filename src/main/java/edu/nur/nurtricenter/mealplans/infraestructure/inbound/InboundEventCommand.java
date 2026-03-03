package edu.nur.nurtricenter.mealplans.infraestructure.inbound;


import an.awesome.pipelinr.Command;
import edu.nur.nurtricenter.mealplans.application.appointment.AttendAppointmentCommand;
import edu.nur.nurtricenter.mealplans.application.appointment.CreateAppointmentCommand;
import edu.nur.nurtricenter.mealplans.application.patient.CreatePatientCommand;

import java.util.HashMap;

public final class InboundEventCommand {

    private static final HashMap<String, Class<? extends Command>> eventCommand;

    static {
        eventCommand = new HashMap<>();
        //Events Patient
        eventCommand.put("paciente.paciente-creado", CreatePatientCommand.class);
        //Events Appointment-Evaluation
        eventCommand.put("citas-evaluaciones.cita.agendada", CreateAppointmentCommand.class);
        eventCommand.put("citas-evaluaciones.cita.atendida", AttendAppointmentCommand.class);
    }

    public static Class<? extends Command> findByEventName(String eventName) {
        return eventCommand.get(eventName);
    }
}

package edu.nur.nurtricenter.mealplans;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.CommandHandlers;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.NotificationHandlers;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "edu.nur.nurtricenter.mealplans")
@EntityScan({
	"edu.nur.nurtricenter.mealplans.infraestructure.persistence.persistenceModel",
	"edu.nur.nurtricenter.mealplans.infraestructure.outbox",
	"edu.nur.nurtricenter.mealplans.infraestructure.inbound"
})
@EnableJpaRepositories(
		basePackages = {
			"edu.nur.nurtricenter.mealplans.infraestructure.persistence.repositories",
			"edu.nur.nurtricenter.mealplans.infraestructure.outbox",
			"edu.nur.nurtricenter.mealplans.infraestructure.inbound"
		})
@OpenAPIDefinition(servers = {@Server(url = "${springdoc.swagger.path-location}")})
@EnableAsync
@EnableScheduling
@ConfigurationPropertiesScan
public class SpringApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringApp.class, args);
	}

	@Bean
	Pipeline pipeline(
			ObjectProvider<Command.Handler> commandHandlers,
			ObjectProvider<Notification.Handler> notificationHandlers,
			ObjectProvider<Command.Middleware> middlewares) {
		return new Pipelinr()
				.with((CommandHandlers) commandHandlers::stream)
				.with((NotificationHandlers) notificationHandlers::stream)
				.with((Command.Middlewares) middlewares::orderedStream);
	}
}

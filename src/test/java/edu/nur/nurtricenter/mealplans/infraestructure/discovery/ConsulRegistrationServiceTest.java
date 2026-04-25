package edu.nur.nurtricenter.mealplans.infraestructure.discovery;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ConsulRegistrationServiceTest {


	@Test
	void buildDefinition_producesConsulPayloadWithCheck() {
		ConsulProperties props = new ConsulProperties();
		props.setServiceId("nur-tricenter-mealplans");
		props.setServiceName("nur-tricenter-mealplans");
		props.setServiceAddress("142.93.120.239");
		props.setServicePort(8081);
		props.setHealthCheckPath("/actuator/health");
		props.setHealthCheckInterval("10s");
		props.setHealthCheckTimeout("3s");
		props.setDeregisterCriticalAfter("30s");
		props.setTags(new String[] { "spring-boot", "mealplans" });

		Map<String, Object> payload = ConsulRegistrationService.buildDefinition(props);

		assertThat(payload.get("ID")).isEqualTo("nur-tricenter-mealplans");
		assertThat(payload.get("Name")).isEqualTo("nur-tricenter-mealplans");
		assertThat(payload.get("Address")).isEqualTo("142.93.120.239");
		assertThat(payload.get("Port")).isEqualTo(8081);
		assertThat(payload.get("Tags")).isEqualTo(new String[] { "spring-boot", "mealplans" });

		@SuppressWarnings("unchecked")
		Map<String, Object> check = (Map<String, Object>) payload.get("Check");
		assertThat(check.get("HTTP")).isEqualTo("http://142.93.120.239:8081/actuator/health");
		assertThat(check.get("Method")).isEqualTo("GET");
		assertThat(check.get("Interval")).isEqualTo("10s");
		assertThat(check.get("Timeout")).isEqualTo("3s");
		assertThat(check.get("DeregisterCriticalServiceAfter")).isEqualTo("30s");
	}

	@Test
	void baseUri_concatenatesSchemeHostPort() {
		ConsulProperties props = new ConsulProperties();
		props.setScheme("http");
		props.setHost("154.38.180.80");
		props.setPort(8500);
		assertThat(props.baseUri()).isEqualTo("http://154.38.180.80:8500");
	}

}

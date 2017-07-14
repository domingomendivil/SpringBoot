package hello;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.springframework.context.annotation.Configuration;

@Configuration

public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		System.out.println("registering JERSEY");
		register(RolesAllowedDynamicFeature.class);
		register(HealthController.class);
		register(new MyApplicationBinder());
		register(AuthenticationFilter.class);
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
	}
}
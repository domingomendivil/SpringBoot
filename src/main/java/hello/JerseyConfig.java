package hello;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration

public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		System.out.println("registering JERSEY");
		register(HealthController.class);
	}
}
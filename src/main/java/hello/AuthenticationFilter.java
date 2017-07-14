package hello;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

public class AuthenticationFilter implements ContainerRequestFilter{

	@Inject
	private Authenticator authenticator;

	
	public void filter(ContainerRequestContext arg0) throws IOException {
		System.out.println("filtering authorizationfilter");
		System.out.println("arg0 "+arg0);
		if (arg0.getHeaders()!=null){
			System.out.println("headers no null");
			List<String> auth = arg0.getHeaders().get("Authorization");
			System.out.println("authorization list "+auth);
			if (auth!=null){
				String authstr = auth.get(0);
				System.out.println("authorization "+authstr);
				User user;
				try {
					System.out.println("Authenticator is "+authenticator);
					user = authenticator.getUser(authstr);
					SecurityContext sc = new RestSecurityContext(user);
					arg0.setSecurityContext(sc);
				} catch (AuthenticationException e) {
					System.out.println("stacktrace");
					e.printStackTrace();
					throw new WebApplicationException(Status.UNAUTHORIZED);
				}
			}
		}else{
			System.out.println("headers null");
		}
	}

}

package hello;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

@Component
@Path("/health")
public class HealthController {
	
	@Inject
	private UserRepository userRepository;
	
	
    @GET
    @Produces("application/json")
    public Health health() {
        return new Health("Jersey: Up and Running!");
    }
    
    @GET
    @Path("/user")
    @Produces("application/json")
    public User getUser() {
    	User user = userRepository.findOne(new Long(2));
    	System.out.println("role: "+user.getRoles().iterator().next());
    	return user;
    }
    
    
    @GET
    @Path("/booking")
    @DenyAll
    @Produces("application/json")
    public User getBookingById() {
    	System.out.println("SE ESTA LLAMANDO A GETBOOKINGBYID");
    	User user = userRepository.findOne(new Long(2));
    	System.out.println("role: "+user.getRoles().iterator().next());
    	return user;
    }

    

}
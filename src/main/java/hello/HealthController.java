package hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/health")
public class HealthController {
	
	@Autowired
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
    	return user;
    }
    

}
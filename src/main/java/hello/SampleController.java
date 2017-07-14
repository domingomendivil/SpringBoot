package hello;

import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class SampleController implements CommandLineRunner{

	 
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Inject
    DataSource dataSource;
    
    @Inject
    CustomerRepository customerRepository;
    
    @Inject
    UserRepository userRepository;
    

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
    	System.out.println("**************************");
    	System.out.println("main run");
        SpringApplication.run(SampleController.class, args);
    }

    @Transactional(readOnly = true)
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
    	System.out.println("user repository "+userRepository);
	        
	}
}

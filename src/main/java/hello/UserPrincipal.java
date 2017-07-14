package hello;

import java.security.Principal;

public class UserPrincipal implements Principal{
	private String name;
	
	public UserPrincipal(String name){
		this.name=name;
	}


	public String getName() {
		return this.name;
	}

}
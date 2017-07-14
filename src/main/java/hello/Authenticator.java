package hello;



public interface Authenticator {
	
	public User getUser(String authorization) throws AuthenticationException;

}

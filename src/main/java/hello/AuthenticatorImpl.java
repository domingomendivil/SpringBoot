package hello;

public class AuthenticatorImpl implements Authenticator{

	@Override
	public User getUser(String authorization) throws AuthenticationException {
		User user=new User();
		user.setLastname("JUAN");
		user.setUserId(new Long(2));
		return user;
	}

}

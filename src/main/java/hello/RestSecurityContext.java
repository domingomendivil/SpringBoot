package hello;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

public class RestSecurityContext implements SecurityContext {
	
	private UserPrincipal userPrincipal;
	private User user;
	
	public RestSecurityContext(User user){
		userPrincipal = new UserPrincipal(user.getLastname());
		this.user = user; 
	}

	
	public boolean isUserInRole(String aRol) {
		System.out.println("is user in role "+aRol);
		return true;
		/**System.out.println("is user in role "+aRol);
		Rol rol = new Rol();
		rol.setName(aRol);
		System.out.println("user roles are "+user.getRoles());
		Iterator<Rol> it =user.getRoles().iterator();
		while (it.hasNext()){
			Rol unRol = it.next();
			System.out.println("un Rol "+unRol.getName());
		}
		boolean res = user.getRoles().contains(rol);
		System.out.println("contiene el rol "+res);
		return res;**/
	}
	
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Principal getUserPrincipal() {
		return userPrincipal;
		
	}

	
	public String getAuthenticationScheme() {
		return "userPassword";
	}

}
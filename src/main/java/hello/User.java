package hello;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6238902800687588733L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	private String password;	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	private String lastname;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId= userId;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = {
			@JoinColumn(name = "lastname", referencedColumnName = "lastname") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })

	private Set<Role> roles;


	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	

}

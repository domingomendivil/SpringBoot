package hello;

public class Health {
	
	private String name;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}

	public Health(String string) {
		name=string;
	}

}

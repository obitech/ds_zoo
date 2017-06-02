package zoo;

public abstract class Animal {

	private String name;
	private Compound compound;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Compound getCompound() {
		return compound;
	}

	public void setCompound(Compound compound) {
		this.compound = compound;
	}

// Use this for debugging
/*	
	@Override
	public String toString() {
		return "Animal [name=" + name + ", type=" + this.getClass() + ", parent-type="+ this.getClass().getSuperclass() +"]";
	}
*/
	
	public String toString() {
		return this.getClass().getSuperclass().getSimpleName() + " " + this.getClass().getSimpleName() +" '"+ name +"'";
 	}
}


public class Student {
	private int id;
	private String name;
	public String surname;
	
	Student (int id,String name,String surname){
		this.setId(id);
		this.setName(name);
		this.surname=surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

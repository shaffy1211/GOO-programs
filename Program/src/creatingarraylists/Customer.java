package creatingarraylists;

public class Customer {
	private String name;
	private int age;
	
	//getters and setters
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	//constructor
	public Customer(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}
	
	public void display() {
		System.out.println("Customer Name: " + getName() + "\n" + "Customer age: " + getAge());
	}
}

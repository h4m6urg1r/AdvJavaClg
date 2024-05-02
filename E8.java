import java.io.Serializable;

public class E8 implements Serializable {
	private String name;
	private double salary;
	private String designation;
	private String company;


	public E8() {
	}


	public E8(String name, double salary, String designation, String company) {
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		this.company = company;
	}


	// Getters and Setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	// toString method to display employee information
	@Override
	public String toString() {
		return "Employee: " + name + ", Salary: " + salary + ", Designation: " + designation + ", Company: " + company;
	}


	public static void main(String[] args) {
		// Create an instance of EmployeeBean
		E8 employee = new E8("Jasmanpreet Singh", 10000000.0, "Web Developer", "Dial Discussions");


		// Display employee information
		System.out.println(employee.toString());
	}
}
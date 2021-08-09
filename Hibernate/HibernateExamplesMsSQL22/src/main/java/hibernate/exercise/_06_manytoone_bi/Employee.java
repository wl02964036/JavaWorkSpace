package hibernate.exercise._06_manytoone_bi;

public class Employee {

	Integer id;
	String employeeId;
	String name;

	public Employee() {
	}

	public Employee(String employeeId, String name) {
		this.employeeId = employeeId;
		this.name = name;
		
	}

	public Employee(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package ch01_oldstyle;
public class Employee {
	int pk;
	String employeeId;
	String name ;
	String email;
	String depId;
	
	public Employee() {
		super();
	}
	public Employee(String employeeId, String name, String email,
			String depId) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.depId = depId;
	}
	public Employee(int pk, String employeeId, String name, String email,
			String depId) {
		super();
		this.pk = pk;
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.depId = depId;
	}
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	
}

package exam;


public class Manager extends Employee{
	private long bonus;
	
	public Manager(int empno, String name, long salary,long bonus) {
		super(empno,name,salary);
		this.bonus = bonus;
	}

	public long getBonus() {
		return bonus;
	}
	public long getSalary() {
		long salary = super.getSalary();
		return salary+bonus;
	}
	

	
}
	    
	    
	    
	
package equals;

public class Employee {

	private String id;//String本身是一個類別，所以她借用objcet父類別

	public Employee(String id) {
		this.id = id;
	}
	
	
	
	
/*	
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())//就是instanceof
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

*/

	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			Employee emp = (Employee)obj;
			//下方的equals是借用文字的逐字比較
			//String有改寫override繼承下來的equals方法
			return this.id.equals(emp.id);

		}

		return false;
	}
	
	@Override
	public int hashCode() {
		//回傳代表物件的數字，通常會跟你equals中比較的屬性有關
		//藉由String hashcode滿足Java的規範
		return id.hashCode();
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("id="+id+",被GC!");
	}
	
	@Override
	public String toString() {
		return String.format("Employee(%s)", id);//改寫toString
	}
	
}
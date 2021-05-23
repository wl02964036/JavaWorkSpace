package exam;

public class TestEmployee {

	public static void main(String[] args) {
			
			Manager e = new Manager(31,"Mary",30000,500);
			Manager f = new Manager(32,"Clair",33220,100);
			

			
			System.out.printf("員工編號:%3d,員工姓名:%s,薪資:%7d\r\n",e.getEmpno(),e.getName(),e.getSalary());
			System.out.printf("員工編號:%3d,員工姓名:%s,薪資:%7d\r\n",f.getEmpno(),f.getName(),f.getSalary());
//			System.out.printf("員工編號:%3d,員工姓名:%s,薪資:%7d,紅利:%5d\r\n",e.getEmpno(),e.getName(),e.getSalary(),e.getBonus());
//			System.out.printf("員工編號:%3d,員工姓名:%s,薪資:%7d,紅利:%5d\r\n",f.getEmpno(),f.getName(),f.getSalary(),f.getBonus());

	}

}

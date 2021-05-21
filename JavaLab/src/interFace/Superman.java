package interFace;

//點Superman 後按 ctrl+1
public class Superman implements Lawyer, Accountant {
	// 3個型態
	@Override
	public void 報稅() {

	}

	@Override
	public void 訴訟() {

	}

	public static void main(String[] args) {

		Superman s = new Superman();
		s.訴訟();
		s.報稅();
		//Anonymous class
		
		//Functional Interface
		Accountant acc = new Accountant() {

			@Override
			public void 報稅() {
				System.out.println("綜合所得稅");

			}
		};

		acc.報稅();
		//lamdba:Functional Interface,介面上只有一個抽象方法 @FunctionalInterface
				Accountant acc1 = () -> {
					System.out.println("綜合所得稅");
				};
				Accountant acc2 = () -> System.out.println("綜合所得稅");
				//Accountant acc2 = System.out.println("綜合所得稅")

		Lawyer l = new Lawyer() {

			@Override
			public void 訴訟() {

			}
		};
		l.訴訟();

	}
}

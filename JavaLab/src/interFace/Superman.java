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

		Accountant acc = new Accountant() {

			@Override
			public void 報稅() {
				// TODO Auto-generated method stub

			}
		};

		acc.報稅();

		Lawyer l = new Lawyer() {

			@Override
			public void 訴訟() {
				// TODO Auto-generated method stub

			}
		};
		l.訴訟();

	}
}

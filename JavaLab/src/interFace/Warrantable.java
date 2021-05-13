package interFace;

public interface Warrantable {
//	int 保固天數();
	
	default int 保固天數() {
		return MAX_WARRANTY;
	}
	
	public static final int MAX_WARRANTY = 365;

}

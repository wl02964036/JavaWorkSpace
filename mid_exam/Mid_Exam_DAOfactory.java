package mid_exam;

public class Mid_Exam_DAOfactory {
	
	private static final Mid_Exam_DAO midExamDao = createMid_Exam_DAO();
	private static final Mid_Exam_Scanner midExamScanner = createMid_Exam_Scanner();
	
	
	//Mid_Exam_DAO
	private static Mid_Exam_DAO createMid_Exam_DAO() {
		Mid_Exam_DAO meDAO = new Mid_Exam_DAO();
		return meDAO;
	}
	
	public static Mid_Exam_DAO getMid_Exam_DAO() {
		return midExamDao;
	}
	
	
	//Mid_Exam_Scanner
	public static Mid_Exam_Scanner createMid_Exam_Scanner() {
		Mid_Exam_Scanner mesScanner = new Mid_Exam_Scanner();
		return mesScanner;
	}
	
	public static Mid_Exam_Scanner getMid_Exam_Scanner() {
		return midExamScanner;
	}
}


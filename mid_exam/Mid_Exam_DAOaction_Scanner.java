package mid_exam;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mid_Exam_DAOaction_Scanner {

	public static void main(String[] args) throws SQLException {
		
		Mid_Exam_Scanner meDAO = Mid_Exam_DAOfactory.getMid_Exam_Scanner();
		
		Scanner scanner = new Scanner(System.in);
		
		// 開連線
		meDAO.createConn();
		try {
		while(true) {
			System.out.println("公布109年4月至110年3月違反勞工退休金條例事業單位名單一覽表");
			System.out.println("請選擇 : 1.新增 2.修改 3.刪除 4.查詢 5.關閉");
			
			int nextScanner = scanner.nextInt();
			
			//1.新增
			if(nextScanner == 1) {
				Mid_Exam_Getset meg1 = new Mid_Exam_Getset();
				System.out.println("此為新增資料");
				
				System.out.println("請輸入: 事業單位名稱/負責人,ex:XXX股份有限公司/蔣XX");
				meg1.setInsname(scanner.next());
				
				System.out.println("請輸入: 違反法規條款,ex:勞工退休金條例第12條第1項");
				meg1.setVio_regu(scanner.next());
				
				System.out.println("請輸入: 違反法規內容,ex:未依規給予勞工資遣費");
				meg1.setVio_cont(scanner.next());
				
				System.out.println("請輸入: 處分字號,ex:府授勞動字第110000000號");
				meg1.setDis_num(scanner.next());
				
				System.out.println("請輸入: 處分日期(西元年/月/日),ex:20200306");
				meg1.setDis_date(scanner.next());
				
				System.out.println("請輸入: 處分金額,ex:30000");
				meg1.setDis_fine(scanner.nextInt());
				
				System.out.println("請輸入: 備註");
				meg1.setRemark(scanner.next());
				
				meDAO.scanner_AddMid_Exam_Getset(meg1);
				
			//2.修改
			}else if (nextScanner == 2) {
				Mid_Exam_Getset meg2 = new Mid_Exam_Getset();
				System.out.println("此為修改資料,由\"處分字號\"搜尋資料");
				
				System.out.println("請輸入: 事業單位名稱/負責人,ex:XXX股份有限公司/蔣XX");
				meg2.setInsname(scanner.next());
				
				System.out.println("請輸入: 違反法規條款,ex:勞工退休金條例第12條第1項");
				meg2.setVio_regu(scanner.next());
				
				System.out.println("請輸入: 違反法規內容,ex:未依規給予勞工資遣費");
				meg2.setVio_cont(scanner.next());
				
				System.out.println("請輸入: 處分日期(西元年/月/日),ex:20200306");
				meg2.setDis_date(scanner.next());
				
				System.out.println("請輸入: 處分金額,ex:30000");
				meg2.setDis_fine(scanner.nextInt());
				
				System.out.println("請輸入: 備註");
				meg2.setRemark(scanner.next());
				
				System.out.println("請輸入: 處分字號,ex:府授勞動字第110000000號");
				meg2.setDis_num(scanner.next());
				
				meDAO.updateByDis_Num(meg2);
				
			//3.刪除
			}else if (nextScanner == 3) {
				Mid_Exam_Getset meg3 = new Mid_Exam_Getset();
				System.out.println("此為刪除資料,由\"處分字號\"搜尋資料");
				
				System.out.println("請輸入: 處分字號,ex:府授勞動字第110000000號");
				meg3.setDis_num(scanner.next());
				
				meDAO.deleteByDis_Num(meg3);
				
				
				
			//4.查詢
			}else if (nextScanner == 4) {
				Mid_Exam_Getset meg4 = new Mid_Exam_Getset();
				System.out.println("此為查詢資料,由\"處分字號\"搜尋資料");
				
				System.out.println("請輸入: 處分字號,ex:府授勞動字第110000000號");
				meg4.setDis_num(scanner.next());
				meDAO.findByDis_Num(meg4);
				
				
			
			//5.關閉
			}else if (nextScanner == 5) {
				System.out.println("程式已關閉");
				break;
				
			}else {
				System.out.println("請重新選擇: 1, 2, 3, 4, 5");
			}
			
			
			
			
		}
		// 關連線
		meDAO.closeConn();
		
		} catch (InputMismatchException e) {
			System.out.println("程式已關閉");
		}
		scanner.close();
		
		
	}

}

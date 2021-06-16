package mid_exam;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.List;

public class Mid_Exam_DAOaction {

	public static void main(String[] args) throws SQLException, IOException {
		
		Mid_Exam_DAO meDAO = Mid_Exam_DAOfactory.getMid_Exam_DAO();
		
		// 開連線
		meDAO.createConn();
		
		// 新增table : vio_pension
//		meDAO.createTable();
		
		//新增CSV方法
//		meDAO.addCSVtoDB();
		
		//查詢資料方法
		Mid_Exam_Getset meg11 = meDAO.findByDisNum("府授勞動字第11000650841號");
		System.out.printf("事業單位名稱/負責人:%s\r\n違反法規條款:%s\r\n違反法規內容:%s\r\n處分字號:%s\r\n處分日期:%s\r\n處分金額:%8d\r\n備註:%s",meg11.getInsname(),meg11.getVio_regu(),meg11.getVio_cont(),meg11.getDis_num(),meg11.getDis_date(),meg11.getDis_fine(),meg11.getRemark());
		
		//從資料庫中讀取CSV，並儲存在特定位置
		List<Mid_Exam_Getset> list_meg = meDAO.getCSVfromDB();
		FileOutputStream fos = new FileOutputStream("C:/mid_exam/EEIT29_31號_紀岱昀.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("事業單位名稱/負責人,違反法規條款,違反法規內容,處分字號,處分日期,處分金額,備註");
		
		for(Mid_Exam_Getset item:list_meg) {
			String line = item.getInsname()+","+item.getVio_regu()+","+item.getVio_cont()+","+item.getDis_num()+","+item.getDis_date()+","+item.getDis_fine()+","+item.getRemark();
			bw.newLine();
			bw.write(line);
		}
		
		bw.close();
		
		
	/*	
		//修改欄位:insname
		Mid_Exam_Getset meg1 = new Mid_Exam_Getset();
		meg1.setOldColname("insname");
		meg1.setNewColname("事業單位名稱/負責人");
		meDAO.updateColumnName(meg1);
		
		//修改欄位:vio_regu
		Mid_Exam_Getset meg2 = new Mid_Exam_Getset();
		meg2.setOldColname("vio_regu");
		meg2.setNewColname("違反法規條款");
		meDAO.updateColumnName(meg2);
		
		//修改欄位:vio_cont
		Mid_Exam_Getset meg3 = new Mid_Exam_Getset();
		meg3.setOldColname("vio_cont");
		meg3.setNewColname("違反法規內容");
		meDAO.updateColumnName(meg3);
		
		//修改欄位:dis_num
		Mid_Exam_Getset meg4 = new Mid_Exam_Getset();
		meg4.setOldColname("dis_num");
		meg4.setNewColname("處分字號");
		meDAO.updateColumnName(meg4);
		
		//修改欄位:dis_date
		Mid_Exam_Getset meg5 = new Mid_Exam_Getset();
		meg5.setOldColname("dis_date");
		meg5.setNewColname("處分日期");
		meDAO.updateColumnName(meg5);
		
		//修改欄位:dis_fine
		Mid_Exam_Getset meg6 = new Mid_Exam_Getset();
		meg6.setOldColname("dis_fine");
		meg6.setNewColname("處分金額");
		meDAO.updateColumnName(meg6);
		
		//修改欄位:remark
		Mid_Exam_Getset meg7 = new Mid_Exam_Getset();
		meg7.setOldColname("remark");
		meg7.setNewColname("備註");
		meDAO.updateColumnName(meg7);
*/		
		
		
		// 關連線
		meDAO.closeConn();
	}

}

package mid_exam;

import java.io.Serializable;

public class Mid_Exam_Getset implements Serializable{

private static final long serialVersionUID =1L;
	
	private String insname;
	private String vio_regu;
	private String vio_cont;
	private String dis_num;
	private String dis_date;
	private int dis_fine;
	private String remark;
//	private String oldColname;
//	private String newColname;
	
	
	
	public Mid_Exam_Getset(){
	}
	
	//資料方法
	public String getInsname() {
		return insname;
	}
	public void setInsname(String insname) {
		this.insname = insname;
	}
	public String getVio_regu() {
		return vio_regu;
	}
	public void setVio_regu(String vio_regu) {
		this.vio_regu = vio_regu;
	}
	public String getVio_cont() {
		return vio_cont;
	}
	public void setVio_cont(String vio_cont) {
		this.vio_cont = vio_cont;
	}
	public String getDis_num() {
		return dis_num;
	}
	public void setDis_num(String dis_num) {
		this.dis_num = dis_num;
	}
	public String getDis_date() {
		return dis_date;
	}
	public void setDis_date(String dis_date) {
		this.dis_date = dis_date;
	}
	public int getDis_fine() {
		return dis_fine;
	}
	public void setDis_fine(int dis_fine) {
		this.dis_fine = dis_fine;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

/*
	//修改欄位
	public String getOldColname() {
		return oldColname;
	}
	public void setOldColname(String oldColname) {
		this.oldColname = oldColname;
	}
	public String getNewColname() {
		return newColname;
	}
	public void setNewColname(String newColname) {
		this.newColname = newColname;
	}
*/	
	
}
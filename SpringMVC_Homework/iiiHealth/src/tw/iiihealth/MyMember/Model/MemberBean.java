package tw.iiihealth.MyMember.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity // 指自己就是java bean //給Hibernate看的
@Table(name = "member") // 指bean對應到名為member的table //給Hibernate看的
@Component("MemberBean") // 指自己就是java bean，並且名稱為MemberBean //給Spring看的，重點是HQL要對到這
public class MemberBean {

	@Id
	@Column(name = "memno")
	private int memno;

	@Column(name = "carename")
	private String carename;

	@Column(name = "caregender")
	private String caregender;

	@Column(name = "rocid2")
	private String rocid2;

	@Column(name = "year2")
	private String year2;

	@Column(name = "month2")
	private String month2;

	@Column(name = "day2")
	private String day2;

	@Column(name = "careaccount1")
	private String careaccount1;

	@Column(name = "carepwd1")
	private String carepwd1;

	@Column(name = "carepwd2")
	private String carepwd2;

	@Column(name = "carephone1")
	private String carephone1;

	@Column(name = "carephone2")
	private String carephone2;

	@Column(name = "careaddr1")
	private String careaddr1;

	@Column(name = "careaddr2")
	private String careaddr2;

	@Column(name = "handbook")
	private String handbook;

	@Column(name = "dementia")
	private String dementia;

	public MemberBean() {
	}

	public MemberBean(int memno, String carename, String caregender, String rocid2, String year2, String month2,
			String day2, String careaccount1, String carepwd1, String carepwd2, String carephone1, String carephone2,
			String careaddr1, String careaddr2, String handbook, String dementia) {
		this.memno = memno;
		this.carename = carename;
		this.caregender = caregender;
		this.rocid2 = rocid2;
		this.year2 = year2;
		this.month2 = month2;
		this.day2 = day2;
		this.careaccount1 = careaccount1;
		this.carepwd1 = carepwd1;
		this.carepwd2 = carepwd2;
		this.carephone1 = carephone1;
		this.carephone2 = carephone2;
		this.careaddr1 = careaddr1;
		this.careaddr2 = careaddr2;
		this.handbook = handbook;
		this.dementia = dementia;
	}

	public MemberBean(String careaccount1, String carepwd1) {
		this.careaccount1 = careaccount1;
		this.carepwd1 = carepwd1;
	}

	public MemberBean(int memno) {
		this.memno = memno;
	}

	public int getMemno() {
		return memno;
	}

	public void setMemno(int memno) {
		this.memno = memno;
	}

	public String getCarename() {
		return carename;
	}

	public void setCarename(String carename) {
		this.carename = carename;
	}

	public String getCaregender() {
		return caregender;
	}

	public void setCaregender(String caregender) {
		this.caregender = caregender;
	}

	public String getRocid2() {
		return rocid2;
	}

	public void setRocid2(String rocid2) {
		this.rocid2 = rocid2;
	}

	public String getYear2() {
		return year2;
	}

	public void setYear2(String year2) {
		this.year2 = year2;
	}

	public String getMonth2() {
		return month2;
	}

	public void setMonth2(String month2) {
		this.month2 = month2;
	}

	public String getDay2() {
		return day2;
	}

	public void setDay2(String day2) {
		this.day2 = day2;
	}

	public String getCareaccount1() {
		return careaccount1;
	}

	public void setCareaccount1(String careaccount1) {
		this.careaccount1 = careaccount1;
	}

	public String getCarepwd1() {
		return carepwd1;
	}

	public void setCarepwd1(String carepwd1) {
		this.carepwd1 = carepwd1;
	}

	public String getCarepwd2() {
		return carepwd2;
	}

	public void setCarepwd2(String carepwd2) {
		this.carepwd2 = carepwd2;
	}

	public String getCarephone1() {
		return carephone1;
	}

	public void setCarephone1(String carephone1) {
		this.carephone1 = carephone1;
	}

	public String getCarephone2() {
		return carephone2;
	}

	public void setCarephone2(String carephone2) {
		this.carephone2 = carephone2;
	}

	public String getCareaddr1() {
		return careaddr1;
	}

	public void setCareaddr1(String careaddr1) {
		this.careaddr1 = careaddr1;
	}

	public String getCareaddr2() {
		return careaddr2;
	}

	public void setCareaddr2(String careaddr2) {
		this.careaddr2 = careaddr2;
	}

	public String getHandbook() {
		return handbook;
	}

	public void setHandbook(String handbook) {
		this.handbook = handbook;
	}

	public String getDementia() {
		return dementia;
	}

	public void setDementia(String dementia) {
		this.dementia = dementia;
	}

}
package ch05.one2one._02.anno.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
// 雙向一對一，可雙向相互查找對方物件。
// 關注標籤: @OneToOne， @PrimaryKeyJoinColumn
@Entity
@Table(name = "Principal_Table_02")
public class PrincipalSharedPrimaryKey {
	// 本類別的主鍵將採『共用主鍵』的方式來產生主鍵，即儲存某School物件時所產生
	// 的主鍵要放入本記錄的主鍵內。
	// 相關的註釋有 @Id，@GeneratedValue，@GenericGenerator
	//
	// 1. @GeneratedValue(generator = "gen")
	// generator = "gen"必須與下一行之@GenericGenerator內的name屬性值一致
	//
	// 2. @GenericGenerator(name = "gen", strategy = "foreign",
	// parameters = { @Parameter(name = "property", value = "school") })
	//
	// strategy: 說明主鍵的生成策略。當strategy = "foreign"時，程式必須
	// 定義 parameters屬性，其內撰寫
	// { @Parameter(name = "property", value = "xxxx") })
	// 其中 xxx 為表示在本類別(Principal)中，會主動生成主鍵之永續類別(School)
	// 的性質名稱。
	//
	// Hibernate會先對School類別對應之表格來新增紀錄，接著才對Principal類別對應之表格新增紀錄。
	//
	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = {
			@Parameter(name = "property", value = "school") })
	private Integer id;
	private String name;
	
	@OneToOne(cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	@PrimaryKeyJoinColumn
	// 表示本類別的主鍵(Primary Key)除了是Principal_Table_02的主鍵外，
	// 同時當做是儲存School表格主鍵的外來鍵
	private SchoolBi school;

	public PrincipalSharedPrimaryKey() {
	}

	public PrincipalSharedPrimaryKey(Integer id, String name, SchoolBi school) {
		this.id = id;
		this.name = name;
		this.school = school;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SchoolBi getSchool() {
		return school;
	}

	public void setSchool(SchoolBi school) {
		this.school = school;
	}

	public String toString() {
		return "校長: " + name + ", 服務學校:" + school.getSchoolName() + ", 地址:" + school.getAddress();
	}

}

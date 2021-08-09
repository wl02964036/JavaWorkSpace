package tw.iiihealth.MyMember.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.iiihealth.MyMember.Model.HealthBean;
import tw.iiihealth.MyMember.Model.HealthDAO;


@Service("healthService")	//告訴大家自己是service，並自己訂名稱為healthService
@Transactional
public class HealthService {
	
	@Autowired	//自動尋找HealthBean
	private HealthDAO healthDAO;
	
	//新增資料
	public int insertHealth(HealthBean healthData) {
		return healthDAO.insertHealth(healthData);
	}
	
	//查詢全部資料
	public List<HealthBean> searchAllHealth() {
		return healthDAO.searchAllHealth();
	}
	
	//查詢單筆資料
	public List<HealthBean> searchHealthByNo(HealthBean healthData) {
		return healthDAO.searchHealthByNo(healthData);
	}
	
	//刪除單筆資料
	public int deleteHealth(HealthBean healthData) {
		return healthDAO.deleteHealth(healthData);
	}
	
	// 修改單筆資料
	public int updateHealth(HealthBean healthData) {
		return healthDAO.updateHealth(healthData);
	}
	
	// 登陸後查詢資料
	public List<HealthBean> searchHealthByAP(HealthBean healthData) {
		return healthDAO.searchHealthByAP(healthData);
	}
	
}

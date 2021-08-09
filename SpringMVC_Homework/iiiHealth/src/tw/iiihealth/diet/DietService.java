package tw.iiihealth.diet;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("DietService")
@Transactional
public class DietService {
	
	@Autowired
	private DietDAO dDAO;
	
	// 新增餐點
	public boolean insert(DietBean d) {
		return dDAO.insert(d);
	}
	
	// 查詢菜單
	public ArrayList<DietBean> queryAll() throws SQLException {
		return dDAO.queryAll();
	}
	
	// 查詢菜單
	public ArrayList<DietBean> queryType(String type) throws SQLException {
		return dDAO.queryType(type);
	}
	
	// 查詢單筆資料
	public DietBean searchByName(String name) {
		return dDAO.searchByName(name);
	}
	

	// 刪除餐點
	public int deleteByName(String name) {
		return dDAO.deleteByName(name);
	}
	
	// 修改餐點
	public int updateByName(DietBean d) {
		return dDAO.updateByName(d);
	}
	
	

}

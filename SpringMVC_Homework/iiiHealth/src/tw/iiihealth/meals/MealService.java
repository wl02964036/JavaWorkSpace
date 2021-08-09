package tw.iiihealth.meals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("MealService")
@Transactional
public class MealService {
	
	@Autowired
	private MealDAO mDAO;
	
	// 新增餐點
	public boolean insert(MealBean m) {
		return mDAO.insert(m);
	}
	
	// 查詢菜單
	public ArrayList<MealBean> queryAll() throws SQLException {
		return mDAO.queryAll();
	}
	
	// 查詢單筆資料
	public MealBean searchByName(String name) {
		return mDAO.searchByName(name);
	}
	
	// 確認單筆資料
//	public boolean findByName(String name) throws SQLException {
//		return mDAO.findByName(name);
//	}

	// 刪除餐點
	public int deleteByName(String name) {
		return mDAO.deleteByName(name);
	}
	
	// 修改餐點
	public int updateByName(MealBean m) {
		return mDAO.updateByName(m);
	}
	
	
}

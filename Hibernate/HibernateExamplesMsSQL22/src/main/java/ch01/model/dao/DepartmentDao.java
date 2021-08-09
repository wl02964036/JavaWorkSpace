package ch01.model.dao;

import ch01.model.Department;

public interface DepartmentDao {
	// 經由Session介面的get()查詢資料庫內的紀錄
	Department get(int pk);

	public void closeFactory();

	Object save(Department dept);
}

package ch01.model.service;

import ch01.model.Department;

public interface DepartmentService {
	// 經由Session介面的get()查詢資料庫內的紀錄
	Department get(int pk);
	Object save(Department dept);
	public void closeFactory();
}

package ch01.model.service.impl;

import ch01.model.Department;
import ch01.model.dao.DepartmentDao;
import ch01.model.dao.impl.DepartmentDaoImpl;
import ch01.model.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	DepartmentDao dao;
	
	public DepartmentServiceImpl() {
		dao = new DepartmentDaoImpl();
	}

	@Override
	public Department get(int pk) {
		return dao.get(pk);
	}



	@Override
	public void closeFactory() {
		dao.closeFactory();
	}

	@Override
	public Object save(Department dept) {
		return dao.save(dept);
	}

}

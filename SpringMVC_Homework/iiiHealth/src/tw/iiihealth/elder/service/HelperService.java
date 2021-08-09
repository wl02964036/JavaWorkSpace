package tw.iiihealth.elder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.iiihealth.elder.dao.HelperDao;
import tw.iiihealth.elder.entity.Helper;



@Service
public class HelperService {
	
	@Autowired
	HelperDao helperDao;
	
	
	@Transactional(rollbackFor = Exception.class)
	public List<Helper> getAllHelper() {
	
		return helperDao.getAllHelper();
	}


	
	@Transactional(rollbackFor = Exception.class)
	public void saveHelper(Helper helper) {
		helperDao.saveHelper(helper);
	}

	
	
	@Transactional(rollbackFor = Exception.class)
	public Helper getUpdate(int id) {
		return helperDao.getUpdate(id);
	}

	
	@Transactional(rollbackFor = Exception.class)
	public void delete(int id) {
		helperDao.delete(id);
	}

	
}

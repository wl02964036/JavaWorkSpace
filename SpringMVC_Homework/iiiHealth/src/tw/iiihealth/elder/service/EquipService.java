package tw.iiihealth.elder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.iiihealth.elder.dao.EquipDao;
import tw.iiihealth.elder.entity.Equip;

@Service
public class EquipService {

	@Autowired
	private EquipDao equipDao;
	
	
	@Transactional(rollbackFor = Exception.class)
	public List<Equip> getAllequip() {
		return equipDao.getAllequip();
	}

	
	
	@Transactional(rollbackFor = Exception.class)
	public void saveEquip(Equip equip) {
		equipDao.saveEquip(equip);	
	}


	@Transactional(rollbackFor = Exception.class)
	public void delete(int id) {
		equipDao.delete(id);	
		
	}


	@Transactional(rollbackFor = Exception.class)
	public Equip getUpdate(int id) {
		return equipDao.getUpdate(id);
	}
}

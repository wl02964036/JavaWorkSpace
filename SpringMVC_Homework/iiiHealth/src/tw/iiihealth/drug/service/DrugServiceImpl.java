package tw.iiihealth.drug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.iiihealth.drug.dao.DrugDAO;
import tw.iiihealth.drug.model.Drug;


@Service 
public class DrugServiceImpl implements DrugService {
	@Autowired
	private DrugDAO DrugDAO;

	public void setDrugDAO(DrugDAO DrugDAO) {
		this.DrugDAO = DrugDAO;
	}

	@Override
	@Transactional
	public void addDrug(Drug p) {
		this.DrugDAO.addDrug(p);
	}

	@Override
	@Transactional
	public void updateDrug(Drug p) {
		this.DrugDAO.updateDrug(p);
	}

	@Override
	@Transactional
	public List<Drug> listDrugs() {
		return this.DrugDAO.listDrugs();
	}

	@Override
	@Transactional
	public Drug getDrugById(int id) {
		return this.DrugDAO.getDrugById(id);
	}

	@Override
	@Transactional
	public void removeDrug(int id) {
		this.DrugDAO.removeDrug(id);
	}

}
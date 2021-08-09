package tw.iiihealth.drug.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import tw.iiihealth.drug.model.Drug;

    @Repository
public interface DrugDAO { 

	public void addDrug(Drug p);
	public void updateDrug(Drug p);
	public List<Drug> listDrugs();
	public Drug getDrugById(int id);
	public void removeDrug(int id);
}
package tw.leonchen.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("pictureService")	//告訴大家自己是service，並自己訂名稱為pictureService
@Transactional
public class PictureService {
	
	@Autowired	//自動尋找PictureDao
	private PictureDao pDao;
	
	public Picture insert(Picture pBean) {
		return pDao.insert(pBean);
	}
	

}

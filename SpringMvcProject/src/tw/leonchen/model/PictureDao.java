package tw.leonchen.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("pictureDao")	//告訴大家自己是Dao，並自己訂名稱為pictureDao
@Transactional	//自動管理開關交易
public class PictureDao {
	@Autowired	//自己找SessionFactory給我
	@Qualifier("sessionFactory")	//怕找不到，可以指名sessionFactory
	private SessionFactory sessionFactory;
	
	public Picture insert(Picture pBean) {
		Session session = sessionFactory.openSession();
		
		if(pBean!=null) {
			session.save(pBean);
		}
		
		return pBean;
	}
}

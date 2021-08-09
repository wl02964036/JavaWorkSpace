package tw.leonchen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("usersDao")
@Transactional
public class UsersDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean checkLogin(Users user) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From Users where username=:user";
		Query<Users> query = session.createQuery(hql, Users.class);
		query.setParameter("user", user.getUsername());
		Users result = query.uniqueResult();

		if (result != null) {
			return true;
		}

		return false;
	}
}

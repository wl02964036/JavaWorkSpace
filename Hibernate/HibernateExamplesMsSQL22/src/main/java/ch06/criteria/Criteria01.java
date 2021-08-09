package ch06.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ch06.HibernateUtils;
import ch06.model.Employee;
// https://www.baeldung.com/hibernate-criteria-queries
public class Criteria01 {

	public static void main(String[] args) {
		Criteria01 hq = new Criteria01();
		List<Employee> list = hq.query1(); 
		if (list != null) {
			for (Employee e : list) {
				System.out.printf("%3d %10s %8d %14s %2d\n", e.getId(), e.getName(), e.getSalary(), e.getBirthday(),
						e.getDepId());
			}
		} else {
			System.out.println("查無資料");
		}

		HibernateUtils.close();
	}

	public List<Employee> query1() {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		List<Employee> list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			// 說明要查詢何種型態的資料
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			
//			No criteria query roots were specified
			Root<Employee> root = cq.from(Employee.class);
//          case 1			
//			cq.select(root).where(cb.gt(root.<Integer>get("salary"), 30000));
//          case 2			
//			cq.select(root).where(cb.lt(root.<Integer>get("salary"), 30000));
//          case 3			
//			cq.select(root).where(cb.like(root.<String>get("name"), "張%"));
//          case 4			
//			cq.select(root).where(cb.between(root.<Date>get("birthday"), Date.valueOf("1970-1-1"), Date.valueOf("1979-12-31")));
//          case 5			
//			cq.select(root).where(cb.isNotNull(root.get("name")));
//          case 6：多個條件(AND)
			Predicate[] predicates = new Predicate[2];
			predicates[0] = cb.lt(root.<Integer>get("salary"), 45000);
			predicates[1] = cb.equal(root.<Integer>get("depId"), 1);
			cq.select(root).where(predicates);
			
//          case 7：多個條件(OR)
			
			Predicate predicates0 = cb.lt(root.<Integer>get("salary"), 330000);
			Predicate predicates1 = cb.equal(root.<Integer>get("depId"), 1);
//			cq.select(root).where(cb.or(predicates0, predicates1));		// OR
//			cq.select(root).where(cb.and(predicates0, predicates1));	// AND
//			cq.select(root).where(predicates0, predicates1);			// AND		
// 			排序			
//			cq.select(root).where(cb.or(predicates0, predicates1))
//							.orderBy(cb.asc(root.get("depId")), cb.desc(root.get("salary")));
//			Query<Employee> query = session.createQuery(cq);
//			list = query.getResultList();
			
			// 計算紀錄比數
			CriteriaQuery<Long> cq0 = cb.createQuery(Long.class);
			Root<Employee> root0 = cq0.from(Employee.class);
			cq0.select(cb.count(root0));
			Query<Long> query0 = session.createQuery(cq0);
			Long result = query0.getSingleResult();
			System.out.println(result);
			// 計算平均值			
			CriteriaQuery<Double> cq1 = cb.createQuery(Double.class);
			Root<Employee> root1 = cq1.from(Employee.class);
			cq1.select(cb.avg(root1.<Double>get("salary")));
			Query<Double> query1 = session.createQuery(cq1);
			Double avgSalary = query1.getSingleResult();
			System.out.println(avgSalary);
			
			// 計算總和			
			CriteriaQuery<Integer> cq2 = cb.createQuery(Integer.class);
			Root<Employee> root2 = cq2.from(Employee.class);
			cq2.select(cb.sum(root2.<Integer>get("salary")));
			Query<Integer> query2 = session.createQuery(cq2);
			Integer sumSalary = query2.getSingleResult();
			System.out.println(sumSalary);

			// 計算max			
			CriteriaQuery<Integer> cq3 = cb.createQuery(Integer.class);
			Root<Employee> root3 = cq3.from(Employee.class);
			cq3.select(cb.max(root3.<Integer>get("salary")));
			Query<Integer> query3 = session.createQuery(cq3);
			Integer maxSalary = query3.getSingleResult();
			System.out.println(maxSalary);
			
			// 計算min			
			CriteriaQuery<Integer> cq4 = cb.createQuery(Integer.class);
			Root<Employee> root4 = cq4.from(Employee.class);
			cq4.select(cb.min(root4.<Integer>get("salary")));
			Query<Integer> query4 = session.createQuery(cq4);
			Integer minSalary = query4.getSingleResult();
			System.out.println(minSalary);
						
			
			
			tx.commit();
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		return list;
	}

}
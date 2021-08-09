package hibernate.exercise._07_manytomany_bi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.exercise._07_manytomany_bi.utils.HibernateUtils;



public class Main_Bi_Insert {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 先準備物件
		Book book1 = new Book("JSP");
		Book book2 = new Book("Hibernate");
		Book book3 = new Book("Spring");
		Book book4 = new Book("RWD");
		Book book5 = new Book("Github");
		Author author1 = new Author("小明"); 
		Author author2 = new Author("小哲"); 
		Author author3 = new Author("小真"); 
		Set<Book> sbook01 = new HashSet<>(Arrays.asList(book1, book2, book3));
		Set<Book> sbook02 = new HashSet<>(Arrays.asList(book4, book5));
		Set<Author> sAuthor01 = new HashSet<>(Arrays.asList(author1));
		Set<Author> sAuthor02 = new HashSet<>(Arrays.asList(author2, author3));

		author1.setBooks(sbook01);
		author2.setBooks(sbook02);
		author3.setBooks(sbook02);
		book1.setAuthors(sAuthor01);
		book2.setAuthors(sAuthor01);
		book3.setAuthors(sAuthor01);
		book4.setAuthors(sAuthor02);
		book5.setAuthors(sAuthor02);
		
		
		session.save(book1);
		session.save(book2);
		session.save(book3);
		session.save(book4);
		session.save(book5);
		
		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}

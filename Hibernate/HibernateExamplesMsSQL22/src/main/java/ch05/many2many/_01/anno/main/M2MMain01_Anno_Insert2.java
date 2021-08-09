package ch05.many2many._01.anno.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.many2many._01.anno.model.Author;
import ch05.many2many._01.anno.model.Book;
import ch05.many2many._01.anno.util.HibernateUtils;
//雙向多對多: 由作者(Author)來找出其撰寫的書籍(Book)，也可以由書籍
//找到作者。

//口訣: 多對多，雙方都有個可以儲存對方物件參考的List/Set物件，簡稱『多方有個多』
//
//
//Step 0: 為Author類別、Book類別加上應有的註釋(@Entity, @Table, @Id, ....)
//Step 1: Book類別 
//定義一個儲存Author物件參考的Set物件，即
//	private Set<Author> authors = new HashSet<Author>(0);
//  
//  接著為authors變數對應的getter()方法定義下列註釋
//	@JoinTable(name = "author_book", 
//		joinColumns = { 
//			@JoinColumn(name = "JT_BOOK_ID", nullable = false, updatable = false) 
//		}, 
//		inverseJoinColumns = { 
//			@JoinColumn(name = "JT_AUTHOR_ID",	nullable = false, updatable = false) 
//		}
//	)
//  joinColumns = {@JoinColumn(name = "FK_BOOK_ID" // 參考Book表格的說明
//  inverseJoinColumns = { @JoinColumn(name = "FK_AUTHOR_ID",  // 參考Book表格的說明


//
//Step 2: Author類別 
//定義一個儲存Book物件參考的Set物件，即
//	private Set<Book> books = new HashSet<Book>(0);
//  
//Step 3: Author類別無需特別的註釋  
//
//

public class M2MMain01_Anno_Insert2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// 建立SessionFactory物件
			sessionFactory = HibernateUtils.getSessionFactory();
			// 取出Session物件
			session = sessionFactory.openSession();
			System.out.println("得到Session物件");
			// 開啟交易
			tx = session.beginTransaction();
			Book book1 = new Book("芭比的快樂人生");
			Book book2 = new Book("芭比奇遇記");
			Book book3 = new Book("芭比的奇幻旅程");
			Book book4 = new Book("芭比的上班日誌");
			Book book5 = new Book("芭比的塗鴉本");
			Author a1 = new Author("芭比");

			Set<Author> set_s = new HashSet<Author>();
			set_s.add(a1); 
	//		
			Book book6 = new Book("Spring框架解析");
			Author a2 = new Author("吳柏毅");
			Author a3 = new Author("穆拉拉");
			Set<Author> set_t = new HashSet<Author>();
			set_t.add(a2);
			set_t.add(a3);
			book6.setAuthors(set_t);


			book1.setAuthors(set_s);
			book2.setAuthors(set_s);
			book3.setAuthors(set_s);
			book4.setAuthors(set_s);
			book5.setAuthors(set_s);
			System.out.println("------------------------------------");
			session.save(book1);
			session.save(book2);
			session.save(book3);
			session.save(book4);
			session.save(book5);
			System.out.println("------------------------------------");
			session.save(book6);
			System.out.println("------------------------------------");
//			String author = "";
//			for(Author a : book1.getAuthors()){
//				author += a.getAuthorName() + " ";
//			}
//			System.out.println(book1.getBookName() + "===>" + author);
//			System.out.println("------------------------------------");
//			author = "";
//			for(Author a : book2.getAuthors()){
//				author += a.getAuthorName() + " ";
//			}
//			System.out.println(book2.getBookName() + "===>" + author);
//			System.out.println("------------------------------------");
//			author = "";
//			for(Author a : book3.getAuthors()){
//				author += a.getAuthorName() + " ";
//			}
//			System.out.println(book3.getBookName() + "===>" + author);
//			System.out.println("------------------------------------");
			
			tx.commit();
			System.out.println("程式執行完畢");
		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}
}

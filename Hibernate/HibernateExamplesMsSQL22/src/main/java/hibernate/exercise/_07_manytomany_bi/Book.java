package hibernate.exercise._07_manytomany_bi;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Book_Id")
	private Integer bookId;

	private String bookName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Author_Book",
		joinColumns = {
			@JoinColumn(name="FK_Book_ID", referencedColumnName = "Book_Id")	
		}, 
		inverseJoinColumns = {
			@JoinColumn(name="FK_Author_ID")	
		}	
	)
	private Set<Author> authors = new HashSet<>();


	public Book() {
	}

	public Book(String bookName) {
		this.bookName = bookName;
	}

	
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	
	

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + "]";
	}
}
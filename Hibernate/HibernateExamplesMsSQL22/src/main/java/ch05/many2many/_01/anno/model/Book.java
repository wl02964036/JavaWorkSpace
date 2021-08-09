package ch05.many2many._01.anno.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Book_M2M_01_ANNO")
public class Book {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BOOK_ID")
	private Integer bookId;
	
	@Column(name = "book_name")
	private String bookName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "author_book",  
        joinColumns = {         // 在Join Table中，儲存本類別之主鍵值的外鍵欄位名稱
            @JoinColumn(name = "FK_BOOK_ID", referencedColumnName = "BOOK_ID") 
        }, 
        inverseJoinColumns = { // 在Join Table中，儲存對應對照類別之主鍵值的外鍵欄位名稱
            @JoinColumn(name = "FK_AUTHOR_ID",    referencedColumnName = "AUTHOR_ID") 
        }
    )

	private Set<Author> authors = new HashSet<Author>(0);

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
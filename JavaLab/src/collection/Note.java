package collection;
//T:type ,裡面可以任意字
public class Note<T> {//重點是這裡要宣告T
	private T content;

	public Note(T content) {
		this.content = content;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
	

}

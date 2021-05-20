package collection;

public class TestNote {

	public static void main(String[] args) {
		
		NoteInt a = new NoteInt(10);
		System.out.println(a.getContent());
		
		NoteString b = new NoteString("HelloWorld");
		System.out.println(b.getContent());
		
		Note<Double> doubleNote = new Note<>(3.0);
		System.out.println(doubleNote.getContent());
		
//		Note<String> stringNote = new Note<String>("aaa");//Note已經限定用Number,所以stringNote不能用String

	}

}

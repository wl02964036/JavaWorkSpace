package collection;

public class TestNote {

	public static void main(String[] args) {
		
		NoteInt a = new NoteInt(10);
		System.out.println(a.getContent());
		
		NoteString b = new NoteString("HelloWorld");
		System.out.println(b.getContent());
		
		Note<Double> doubleNote = new Note<>(3.0);
		System.out.println(doubleNote.getContent());

	}

}

package reference;

/**
 * Created by vincent on 2017/7/10.
 */
public class PassStringTest {
    public static void main(String[] args) {
        
        String name = "David";
        System.out.println("before update name = "+name);//David
        update(name);
        System.out.println("after update name = "+name);//David?Vincent?
        
    }

    public static void update(String name1){
        name1 = "Vincent";
    }
}

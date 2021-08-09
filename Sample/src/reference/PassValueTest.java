package reference;

/**
 * Created by vincent on 2017/7/10.
 */
public class PassValueTest {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("呼叫print前 a值 ="+a);//10 第一步驟
        print(a);
        System.out.println("呼叫print後 a值 = "+a);//10 第三步驟
    }

    public static void print(int aa){
        aa = aa+ 1;
        System.out.println("印出print方法中的aa="+aa);//11 第二步驟
    }

}

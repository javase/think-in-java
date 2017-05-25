package think.in.java.allisobject;

/**
 * Created by limenghua on 2017/5/25.
 */
public class MethodInitTest {
    static int intOut;
    int intOut2;

    public static void main(String[] args) {
        int intIn;
        System.out.println(String.format("成员变量是有默认值的：%d", intOut));
        // System.out.println(intIn);  方法内的变量必须初始化，否则会报错

        new MethodInitTest().getNotStaticMember();
        System.out.println(String.format("new出来实例后，访问类的非静态成员变量：%d", new MethodInitTest().intOut2));

        HelloDate.main(null);
    }

    private void getNotStaticMember() {
        System.out.println(String.format("打印非静态的成员：%d", intOut2));
    }

}

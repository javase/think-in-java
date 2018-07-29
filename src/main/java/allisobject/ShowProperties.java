package allisobject;

/**
 * Created by limenghua on 2017/5/25.
 */
public class ShowProperties {
    public static void main(String[] args) {
        /**
         * System.out 你可以把结果(System.getProperties().list())发送到任何地方，例如发送到文件中
         */
        System.getProperties().list(System.out);
        System.out.println(String.format("user.name:%s", System.getProperty("user.name")));
        System.out.println(String.format("java.library.path:%s", System.getProperty("java.library.path")));
    }
}

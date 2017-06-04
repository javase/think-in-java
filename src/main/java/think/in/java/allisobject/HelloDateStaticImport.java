package think.in.java.allisobject;

import java.util.Date;

import static think.in.java.common.Print.*;

/**
 * 阅读《java编程思想》写的例子,使用静态导入<br/>
 * Created by limenghua on 2017/5/26.
 *
 * @author limenghua
 * @version 1.0
 */
public class HelloDateStaticImport {
    /**
     * 使用更简洁的方式打印当前时间
     *
     * @param args args array
     * @throws null No exceptions throw
     */
    public static void main(String[] args) {
        print("Hello, it's : ");
        print(new Date());
    }
}

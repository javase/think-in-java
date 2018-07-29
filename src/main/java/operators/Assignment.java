package operators;

import static common.Print.*;

/**
 * Created by limenghua on 2017/5/26.
 */
class Tank {
    int level;
}

public class Assignment {
    public static void main(String[] args) {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank();

        tank1.level = 9;
        tank2.level = 47;
        print(String.format("1:t1.level:%d,t2.level:%d", tank1.level, tank2.level));

        tank1 = tank2;
        print(String.format("2:t1.level:%d,t2.level:%d", tank1.level, tank2.level));

        tank1.level = 27;
        print(String.format("3:t1.level:%d,t2.level:%d", tank1.level, tank2.level));

    }
}

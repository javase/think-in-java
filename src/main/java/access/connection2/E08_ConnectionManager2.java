package access.connection2;

public class E08_ConnectionManager2 {
    public static void main(String args[]) {
        Connection[] ca = new Connection[10];
        // Use up all the connections
        for (int i = 0; i < 10; i++) {
            ca[i] = ConnectionManager.getConnection();
        }
        // Should produce "null" since there are no
        // more connections:
        // 没有更多的连接了
        System.out.println(ConnectionManager.getConnection());
        // Return connections, then get them out:

        /**
         * 每次使用完连接后，使用checkIn()进行了归还，所以下次还可以获取到connection0
         */
        for (int i = 0; i < 5; i++) {
            ca[i].checkIn();
            Connection c = ConnectionManager.getConnection();
            System.out.println(String.format("getConnection:[%s]", c));
            c.doSomething();
            c.checkIn();
            System.out.println("------------------------------------");
        }
        System.out.println("每次使用完连接后，使用checkIn()进行了归还，所以下次还可以获取到connection0");
    }
} /* Output: 
null 
Connection 0 
Connection 0 
Connection 0 
Connection 0 
Connection 0 
*///:~ 
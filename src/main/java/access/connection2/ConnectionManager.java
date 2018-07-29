package access.connection2;

public class ConnectionManager {
    private static Connection[] pool = new Connection[10];

    static {
        for (int i = 0; i < pool.length; i++) {
			pool[i] = new Connection();
		}
    }

    // Produce the first available connection:
    public static Connection getConnection() {
        for (int i = 0; i < pool.length; i++) {
			if (pool[i] != null) {
				Connection c = pool[i];
				pool[i] = null; // Indicates "in use"
				System.out.println(String.format("pool[%d] is pushed", i));
				return c;
			}
		}
        return null; // None left
    }

    /**
     * 找到第一个空的位置，并且把参数赋值给这个位置
     *
     * @param c
     */
    public static void checkIn(Connection c) {
        for (int i = 0; i < pool.length; i++) {
			if (pool[i] == null) {
				System.out.println(String.format("[%s]放在了位置[%d]", c, i));
				pool[i] = c; // Check it back in
				return;
			}
		}
    }
} ///:~ 
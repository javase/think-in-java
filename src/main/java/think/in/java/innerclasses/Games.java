package think.in.java.innerclasses;//: interfaces/Games.java
// A Game framework using Factory Methods.

import static net.mindview.util.Print.*;

interface Game {
	boolean move();
}

interface GameFactory {
	Game getGame();
}

/**
 * 西洋棋
 */
class Checkers implements Game {
	private int moves = 0;

	private static final int MOVES = 3;

	public boolean move() {
		print("Checkers move " + moves);
		return ++moves != MOVES;
	}

	public static GameFactory gameFactory = new GameFactory() {
		public Game getGame() {
			return new Checkers();
		}
	};
}

//class CheckersFactory implements GameFactory {
//	public Game getGame() {
//		return new Checkers();
//	}
//}

/**
 * 国际象棋
 */
class Chess implements Game {
	private int moves = 0;

	private static final int MOVES = 4;

	public boolean move() {
		print("Chess move " + moves);
		return ++moves != MOVES;
	}

	public static GameFactory gameFactory = new GameFactory() {
		public Game getGame() {
			return new Chess();
		}
	};
}

//class ChessFactory implements GameFactory {
//	public Game getGame() {
//		return new Chess();
//	}
//}

/**
 * 使用匿名内部类，对之前的练习进行改造
 */
public class Games {
	public static void playGame(GameFactory factory) {
		Game s = factory.getGame();
		// 使用工厂方法的好处：在不同类型的游戏中，复用Games类中的代码
		while (s.move())
			;
	}

	public static void main(String[] args) {
		playGame(Checkers.gameFactory);
		playGame(Chess.gameFactory);
	}
} /* Output:
Checkers move 0
Checkers move 1
Checkers move 2
Chess move 0
Chess move 1
Chess move 2
Chess move 3
*///:~

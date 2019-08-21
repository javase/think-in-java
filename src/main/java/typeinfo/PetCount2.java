package typeinfo;//: typeinfo/PetCount2.java

import typeinfo.pets.Pets;

/**
 * 外观模式（Facade Pattern）隐藏系统的复杂性， 并向客户端提供了一个客户端可以访问系统的接口.
 * 使用外观，可以很容易地测试 LiteralPetCreator
 */
public class PetCount2 {
	public static void main(String[] args) {
		PetCount.countPets(Pets.creator);
	}
} /* (Execute to see output) *///:~

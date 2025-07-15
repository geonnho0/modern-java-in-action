package chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MethodReferenceExample {


  static Map<String, Function<Integer, Fruit>> fruitMap = new HashMap<>();
  static {
    fruitMap.put("apple", Apple::new);  // Apple 생성자를 참조
    fruitMap.put("banana", Banana::new);  // Banana 생성자를 참조
  }

  public static Fruit getFruit(String fruit, Integer weight) {
    return fruitMap.get(fruit.toLowerCase())
        .apply(weight);
  }

  public static void main(String[] args) {
    Fruit apple = getFruit("apple", 10);
    Fruit banana = getFruit("banana", 20);
  }


  static class Fruit {
    Integer weight;

    public Fruit() {
      this.weight = 0;
    }
  }

  static class Apple extends Fruit {
    public Apple(Integer weight) {
      this.weight = weight;
    }
  }
  static class Banana extends Fruit {
    public Banana(Integer weight) {
      this.weight = weight;
    }
  }
}

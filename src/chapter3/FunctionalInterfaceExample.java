package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {

  int instanceValue = 10;  // heap

  /**
   * 지역 변수는 스택, 인스턴스 변수는 힙에 저장됨
   *
   * 람다가 스레드에 실행되고 변수를 할당한 스레드가 사라져 변수 할당이 해제된 경우,
   * 람다를 실행하는 스레드에서 해당 변수에 계속 접근함
   * 따라서 자바 구현에서는 지역 변수의 복사본을 가져오기에 복사본의 값이 바뀌지 않아야 함
   */
  public void testMethod() {
    int localValue = 20;  // stack
    // 람다 표현식에서 지역 변수는 final 또는 effectively final이어야 함
    // final 또는 effectively final이란, 변수의 값이 변경되지 않는다는 의미
    Runnable r = () -> {
      // 람다 표현식에서 외부 클래스의 인스턴스 변수에 접근 가능
      System.out.println("Instance Value: " + instanceValue);
      // 람다 표현식에서 지역 변수에 접근 가능
      System.out.println("Local Value: " + localValue);
    };
//     localValue = 30;  // 컴파일 에러 발생, localValue는 effectively final이어야 함
  }


  // T형 객체를 받아 boolean을 반환
  class MyPredicate<T> {

    public <T> List<T> filter(List<T> list, Predicate<T> p) {
      List<T> result = new ArrayList<>();
      for (T t : list) {
        if (p.test(t)) {
          result.add(t);
        }
      }
      return result;
    }
  }

  // T형 객체를 받아 void를 반환하는 accept 추상 메소드를 정의
  class MyConsumer<T> {

    public void accept(T t) {
      // T형 객체를 소비하는 메소드
      System.out.println(t);
    }
  }


}

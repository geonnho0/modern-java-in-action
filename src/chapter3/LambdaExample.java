package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LambdaExample {
  public static String processFile(BufferedReaderProcessor p) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
      return p.process(br);
    }
  }

  interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
  }

  public static void main(String[] args) throws IOException {
    String oneLine = processFile((BufferedReader br) -> br.readLine());
    String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
  }
}

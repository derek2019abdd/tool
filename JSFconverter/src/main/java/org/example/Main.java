package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  static final String filename = "src/main/resources/example.jsp";
  public static void main(String[] args) {

    try {
      String content = new String(Files.readAllBytes(Paths.get(filename)));
      System.out.println(content);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }


  }
}
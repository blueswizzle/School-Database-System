package database;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
      School school = new School("Florida Atlantic University");
      UI ui = new UI(school);
      ui.start();



    }
}

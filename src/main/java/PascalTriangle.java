import java.util.List;
import java.util.ArrayList;

public class MyClass {
    public static void main(String args[]) {
      int numberOfRows = 6;
      List<List<Integer>> pascalTriangle = preparePascalTriangle(numberOfRows);
      System.out.println("Pascal triangle with " + numberOfRows + " rows is as below:");
      for(List<Integer> row : pascalTriangle) {
          for(Integer entry : row) {
              System.out.print(entry + " ");
          }
          System.out.println();
      }
    }
    
    public static List<List<Integer>> preparePascalTriangle(int rows) {
        List<List<Integer>> pascalTriangle =  new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        pascalTriangle.add(firstRow);
        
        for(int i = 1; i < rows; i++) {
            List<Integer> previousRow = pascalTriangle.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for(int j = 0; j < previousRow.size() - 1; j++) {
                currentRow.add(previousRow.get(j) + previousRow.get(j + 1));
            }
            currentRow.add(1);
            pascalTriangle.add(currentRow);
        }
        return pascalTriangle;
    }
}

package icamp.cRecursionMemoization.ic13PrintAllCombinations;

public class StringBuilderAsBuffer {
  static int[] input = {1, 2, 3, 4, 5};
  static int limit = 3;
  public static void main(String[] args) {
    printCombinations(new StringBuilder(),0);
  }

  private static void printCombinations(StringBuilder prefix, int idx) {
    if (prefix.length() == limit) {
      System.out.println(prefix);
      return;
    }
    for (int i = idx; i < input.length; i++) {
      printCombinations(prefix.append(input[i]), i + 1);
      prefix.deleteCharAt(prefix.length() - 1);
    }
  }
}

package icamp.aArraysAndStrings.ic05SubarraySums.maxSumKadane.PrefixSums;

public class TestRunner {
  public static void main(String[] args) {
    runTestSuite(new FindSubArrThatSumsToZero());
  }

  private static void runTestSuite(ITestable o) {
    System.out.printf("Testing %s :%n", o.getClass().getSimpleName());
    System.out.println("***************");
    o.getResult(new int[]{2, 4, -2, 1, -3, 5, -3}, 0);
    o.getResult(new int[]{1, 5, -7, 0}, 0);
    o.getResult(new int[]{2, 4, 6}, 0);
    o.getResult(new int[]{2, 4, 6, -6, -4, -2}, 0);
    o.getResult(new int[]{2, 4, 6, -2, -2, -2}, 0);
    o.getResult(new int[]{-2}, 0);
    o.getResult(new int[]{0}, 0);
    System.out.println("***************");
  }
}

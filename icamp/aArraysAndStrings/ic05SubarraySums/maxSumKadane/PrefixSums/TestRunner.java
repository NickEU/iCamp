package icamp.aArraysAndStrings.ic05SubarraySums.maxSumKadane.PrefixSums;

public class TestRunner {
  public static void main(String[] args) {
    runTestSuite(new FindSubArrThatSumsToZero(), 0, LoggingMode.VERBOSE);
    runTestSuite(new FindSubArrThatSumsToK(), 0, LoggingMode.VERBOSE);
    runTestSuite(new FindSubArrThatSumsToK(), -4, LoggingMode.VERBOSE);
  }

  private static void runTestSuite(ITestable o, int targetSum, LoggingMode logMode) {
    System.out.printf("Testing %s :%n", o.getClass().getSimpleName());
    System.out.println("***************");
    o.getResult(new int[]{2, 4, -2, 1, -3, 5, -3}, targetSum, logMode);
    o.getResult(new int[]{1, 5, -7, 0}, targetSum, logMode);
    o.getResult(new int[]{2, 4, 6}, targetSum, logMode);
    o.getResult(new int[]{2, 4, 6, -6, -4, -2}, targetSum, logMode);
    o.getResult(new int[]{2, 4, 6, -2, -2, -2}, targetSum, logMode);
    o.getResult(new int[]{-2}, targetSum, logMode);
    o.getResult(new int[]{0}, targetSum, logMode);
    System.out.println("***************");
  }
}

package icamp.aArraysAndStrings.ic04ArrayPartitioning.moveAllZeroesToStart;

import java.util.Arrays;

public class TestRunner {
  public static void main(String[] args) {
    TestRunner t = new TestRunner();

    System.out.println("Testing CalcUsingTwoArrays:");
    t.runTestSuite(new CalcUsingTwoArrays());
    System.out.println("***************");
    System.out.println("Testing CalcUsingOneArray:");
    t.runTestSuite(new CalcUsingOneArray());
    System.out.println("***************");
    System.out.println("Testing CalcInPlace:");
    t.runTestSuite(new CalcInPlace());
  }

  private void runTestSuite(ITestable o) {
    System.out.println(Arrays.toString(o.getResult(new int[] {2, 4, 0, 3, 0, 1, 0})));
    System.out.println(Arrays.toString(o.getResult(new int[] {1})));
    System.out.println(Arrays.toString(o.getResult(new int[] {0, 0, 0})));
    System.out.println(Arrays.toString(o.getResult(new int[] {2, 3, 0, 0, 0})));
    System.out.println(Arrays.toString(o.getResult(new int[] {0, 0, 0, 5, 7, 9})));
    System.out.println(Arrays.toString(o.getResult(new int[] {})));
    System.out.println(Arrays.toString(o.getResult(null)));
  }
}

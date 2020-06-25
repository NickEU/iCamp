package icamp.bBinarySearch.ic11BSOverIntegerSpace;

public class Tester {
  public static void main(String[] args) {
    SquareRootFinderBad a = new SquareRootFinderBad();
    runTestSuite(a);
  }

  private static void runTestSuite(ITestable o) {
    System.out.println(o.getResult(0) == 0);
    System.out.println(o.getResult(-5) == -1);
    System.out.println(o.getResult(5) == 2);
    System.out.println(o.getResult(8) == 2);
    System.out.println(o.getResult(10) == 3);
    System.out.println(o.getResult(999) == 31);
    System.out.println(o.getResult(1_073_741_824) == 32_768);
    System.out.println(o.getResult(1_073_741_825) == -1);
  }
}

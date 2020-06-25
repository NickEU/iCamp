package icamp.bBinarySearch.ic11BSOverIntegerSpace;

public class SquareRootFinderBad implements ITestable {
  // O(logn) time O(1) space
  public int getResult(int num) {
    if (num < 0 || num > 1_073_741_824) {
      return -1;
    }
    int start = 1;

    // trying to find the largest possible integer that
    // is a potential sqrt value for num in O(logn) time
    while (start * start < num) {
      start *= 2;
    }

    int lo = start / 2;
    int hi = start;

    // pinpointing the exact integerFloor(sqrt(num)) in O(logn) time
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int potentialNum = mid * mid;
      int next = mid + 1;
      if (potentialNum == num || potentialNum < num && next * next > num) {
        return mid;
      } else if (potentialNum > num) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    throw new IllegalStateException();
  }
}

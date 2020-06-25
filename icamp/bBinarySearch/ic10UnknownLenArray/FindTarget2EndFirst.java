package icamp.bBinarySearch.ic10UnknownLenArray;

public class FindTarget2EndFirst implements ITestable{
  @SuppressWarnings("InfiniteLoopStatement")
  @Override
  public int getIndex(int[] nums, int target) {
    System.out.println("Looking for " + target);
    // find the end index
    int potentialEnd = 1;
    try {
      while (true) {
        int thisMightThrow = nums[potentialEnd];
        potentialEnd *= 2;
      }
    }
    catch(ArrayIndexOutOfBoundsException e) {
      potentialEnd /= 2;
      System.out.println("Last inbounds IDX = " + potentialEnd);
    }

    // pinpoint the end
    int lastSuccess = potentialEnd;
    int lastFail = potentialEnd * 2;
    while (lastSuccess + 1 < lastFail) {
      int idx = lastSuccess + (lastFail - lastSuccess) / 2;
      try {
        int thisMightThrow = nums[idx];
        lastSuccess = idx;
      } catch (ArrayIndexOutOfBoundsException e) {
        lastFail = idx;
      }
    }

    // use regular binary search to find the target
    int start = 0;
    int end = lastSuccess;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] > target) {
        end = mid - 1;
      } else if (nums[mid] < target) {
        start = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }
}

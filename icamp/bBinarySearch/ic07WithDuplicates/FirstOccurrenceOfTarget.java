package icamp.bBinarySearch.ic07WithDuplicates;

public class FirstOccurrenceOfTarget {
  public static void main(String[] args) {
    int[] input = {1,3,4,6,6,6,7};
    System.out.println(getResult(input, 6));
  }

  private static int getResult(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int lastSeenTargetIdx = -1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      int currEl = nums[mid];
      if (currEl < target) {
        if (lastSeenTargetIdx == mid + 1) {
          break;
        } else {
          start = mid + 1;
        }
      } else {
        end = mid - 1;
        if (currEl == target)
          lastSeenTargetIdx = mid;
      }
    }
    return lastSeenTargetIdx;
  }
}

package icamp.bBinarySearch.ic08RecordAndMoveOn;

// Given a sorted array of Integers, find the target. If the target is not found,
// return the element closest to the target.

// Q. How do you want to return the output?
// A. Return the index of the closest element.

// Q. What if there are two elements equally distant from target?
// A. Return either one.

public class FindClosestToTarget {
  public static void main(String[] args) {
    int[] input = {1,2,4,5,7,8,9};
    int actual = returnIdx(input, 6);
    System.out.println(actual == 3 || actual == 4);
    actual = returnIdx(new int[] {1, 2, 3, 4, 5}, 3);
    System.out.println(actual == 2);
    actual = returnIdx(new int[] {2, 2, 3, 4, 5}, 2);
    System.out.println(actual == 0 || actual == 1);
    actual = returnIdx(new int[] {10, 20, 30}, 15);
    System.out.println(actual == 0 || actual == 1);
    actual = returnIdx(new int[] {10, 20, 30}, 36);
    System.out.println(actual == 2);
    actual = returnIdx(new int[] {10, 20, 30, 40}, 5);
    System.out.println(actual == 0);
  }

  private static int returnIdx(int[] nums, int target) {
    int closestIdx = -1;

    if (nums == null || nums.length == 0) {
      return closestIdx;
    }

    int start = 0;
    int end = nums.length - 1;
    Integer closestDist = null;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      int currEl = nums[mid];

      // issues with overflow for rly big distances,
      // for ex curr el = -(2^30 + 2^31) target = 2^30 + 2^31
      int distToTarget = Math.abs(currEl - target);

      if (closestDist == null || distToTarget < closestDist) {
        closestDist = distToTarget;
        closestIdx = mid;
      }

      if (currEl > target) {
        end = mid - 1;
      } else if (currEl < target) {
        start = mid + 1;
      } else {
        return mid;
      }
    }

    // should never happen
    return closestIdx;
  }
}

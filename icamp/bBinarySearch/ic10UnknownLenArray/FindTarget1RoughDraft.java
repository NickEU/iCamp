package icamp.bBinarySearch.ic10UnknownLenArray;

public class FindTarget1RoughDraft implements ITestable{
  @Override
  public int getIndex(int[] nums, int target) {
    int indexWithinBounds = Integer.MAX_VALUE - 1;
    System.out.println("Looking for " + target);

    while (indexWithinBounds > 0) {
      try {
        System.out.println("Found array element " + nums[indexWithinBounds] + " at index " + indexWithinBounds);
        break;
      } catch (ArrayIndexOutOfBoundsException e) {
        //System.out.println(indexWithinBounds + " too big");
        indexWithinBounds /= 2;
      }
    }

    int start = 0;
    int end = indexWithinBounds;
    int prevSuccessful = end;
    while (start <= end) {
      try {
        int mid = start + (end - start) / 2;
        int currEl = nums[mid];
        int endEl = nums[end];
        prevSuccessful = end;
        if (target > endEl) {
          start = end + 1;
          end *= 2;
          continue;
        }
        if (currEl > target) {
          end = mid - 1;
        } else if (currEl < target) {
          start = mid + 1;
        } else {
          return mid;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        if (prevSuccessful + 1 == end) {
          return -1;
        }
        int prevFailed = end;
        end = prevSuccessful + (prevFailed - prevSuccessful) / 2;
      }
    }
    return -1;
  }
}

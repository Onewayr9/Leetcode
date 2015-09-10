/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 0) {
            return -1;
        }
        int start = 1, end = n, mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (isBadVersion(mid) == false) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (isBadVersion(start) == true) {
            return start;
        } else if (isBadVersion(end) == true) {
            return end;
        } else {
            return -1; // not found
        }
    }
}
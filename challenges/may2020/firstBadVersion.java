/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid-1)) {
                    return mid;
                }
                hi = mid;
            }
            else {
                if (isBadVersion(mid+1)) {
                    return mid+1;
                }
                lo = mid;
            }
        }
        
        return -1;
    }
}

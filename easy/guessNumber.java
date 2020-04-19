/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 0;
        int hi = n;
        int mid = 0;
        int g = 0;
        
        while (lo <= hi) {
            // prevent integer overflow
            mid = lo + (hi - lo) / 2;
            g = guess(mid);
            
            if (g == 0) {
                return mid;
            }
            else if (g == 1) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        
        return -1;
    }
}

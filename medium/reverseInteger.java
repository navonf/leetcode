class Solution {
    public int reverse(int x) {
        long result = 0;
        boolean isNegative = x < 0;
        long reverseNumber = (long) Math.abs(x);
        LinkedList<Long> peeledNumbers = new LinkedList<>();
        
        while (reverseNumber > 0) {
            peeledNumbers.add(reverseNumber % 10);
            reverseNumber /= 10;
        }

        while (peeledNumbers.size() > 0) {
            long num = peeledNumbers.poll();
            result += Math.pow(10, peeledNumbers.size()) * num;

            if (result > Integer.MAX_VALUE) { return 0; }
        }

        return isNegative ? (int) result * -1 : (int) result;
    }

    /*
    423 % 10 = 3, 423/10 = 42
    42 % 10  = 2, 42/10 = 4
    4 % 10   = 4

    [4, 2, 3]
    10 ^ 2 = 100 * 4 = 400
    10 ^ 1 = 10 * 2 = 20
    10 ^ 0 = 1 * 3 = 3
    423

    mod 10 to peel each number, divide by 10 as you go
    with each number multiply by 10^list.length-1 and add peeled number
     */
}

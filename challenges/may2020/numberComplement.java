class Solution {
    public int findComplement(int num) {
        int copy = num;
        int bit = 1;
        while (copy > 0) {
            num = num ^ bit;
            bit = bit << 1;
            copy = copy >> 1;
        }
        return num;
    }
}

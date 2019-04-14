class Solution {
    public int reverse(int x) {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean negative = false;
        int multiplier = 0;
        
        if(x < 0) {
            negative = true;
        }
        
        x = Math.abs(x);
        // 123
        // 123 % 10 = 3,    123 / 10 = 12
        // 12 % 10 = 2,     12 / 10 = 1
        // 1 % 10 = 1,      1 / 10 = 0
        while(x > 0) {
            int peel = x % 10;
            q.offer(peel);
            x /= 10;
            multiplier++;
        }
        
        if(multiplier > 0) {
            multiplier--;
        }
        
        while(!q.isEmpty()) {
            int num = q.poll();
            x += num * Math.pow(10, multiplier);
            multiplier--;
        }
        
        if(x >= Integer.MAX_VALUE) {
            return 0;
        }
        
        if(x <= Integer.MIN_VALUE) {
            return 0;
        }
        
        if(negative) {
            x *= -1;
        }
        
        return x;
    }
}

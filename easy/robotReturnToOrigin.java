class Solution {
    public boolean judgeCircle(String moves) {
        Point p = new Point(0, 0);
        for(char c : moves.toCharArray()) {
            updatePosition(c, p);
        }
        return p.x == 0 && p.y == 0;   
    }
    
    public void updatePosition(char c, Point p) {
        if(c == 'U') {
            p.x++;
        }
        else if(c == 'D') {
            p.x--;
        }
        else if(c == 'L') {
            p.y--;
        }
        else {
            p.y++;
        }
    }
}

class Point {
    public int x;
    public int y;
    
    Point(int xPoint, int yPoint) {
        this.x = xPoint;
        this.y = yPoint;
    }
}

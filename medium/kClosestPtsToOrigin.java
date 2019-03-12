class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        PriorityQueue<PointDist> pq = new PriorityQueue<>(new Comparator<PointDist>() {
            @Override
            public int compare(PointDist p1, PointDist p2) {
                if(p1.distance > p2.distance) {
                    return 1;
                }
                
                if(p1.distance < p2.distance) {
                    return -1;
                }
                
                return 0;
            }
        });
        
        for(int[] pointList : points) {
            PointDist pd = new PointDist(pointList[0], pointList[1]);
            pq.offer(pd);
        }
        
        int i = 0;
        while(i < K) {
            PointDist pd = pq.poll(); 
            ans[i][0] = pd.point.x;
            ans[i][1] = pd.point.y;
            i++;
        }
        
        return ans;
        
    }
}

class PointDist {
    public Point point;
    public double distance;
    
    PointDist(int x, int y) {
        Point thisP = new Point(x, y);
        this.point = thisP;
        this.distance = calcDistanceFromOrigin(x, y);
    }
    
    private double calcDistanceFromOrigin(int x, int y) {
        return Math.sqrt((x*x) + (y*y));
    }
}

import java.util.Comparator;


public class Point implements Comparable<Point> {
   //public final Comparator<Point> SLOPE_ORDER;        // compare points by slope to this point

   //public Point(int x, int y)                         // construct the point (x, y)

   //public   void draw()                               // draw this point
   //public   void drawTo(Point that)                   // draw the line segment from this point to that point
  // public String toString()                           // string representation

   //public    int compareTo(Point that)                // is this point lexicographically smaller than that point?
  // public double slopeTo(Point that)                  // the slope between this point and that point
    
    private final int x;
    private final int y;
    
    public final Comparator<Point> Slope_order = new bySlope();
    
    private class bySlope implements Comparator<Point> {
        public int compare(Point a, Point b){
            double ma = slopeTo(a);
            double mb = slopeTo(b);
            if (ma > mb) return 1;
            else if (ma < mb) return -1;
            else return 0;
        }
    }
        
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }
    
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
    
    public int compareTo(Point that){
        if (this.y > that.y) return 1;
        else if (this.y < that.y) return -1;
        else {
            if (this.x > that.x) return 1;
            else if (this.x < that.x) return -1;
            else return 0;
        }
    }
    
    public double slopeTo(Point that){
        if (this.x == that.x) return Double.POSITIVE_INFINITY;
        if (compareTo(that) == 0) return Double.NEGATIVE_INFINITY; 
        else return (that.y-this.y) / (that.x - this.x);
    }
    
    public static void main(String[] args){
        while (true){
            int x1 = StdIn.readInt();
            int y1 = StdIn.readInt();
            int x2 = StdIn.readInt();
            int y2 = StdIn.readInt();
            int x3 = StdIn.readInt();
            int y3 = StdIn.readInt();
            Point point1 = new Point(x1, y1);
            Point point2 = new Point(x2, y2);
            Point point3 = new Point(x3, y3);
            
            StdOut.println(point1.compareTo(point2));
            StdOut.println(point1.slopeTo(point2));
            StdOut.println(point1.slopeTo(point3));
            
            
            StdDraw.setXscale(0, 10);
            StdDraw.setYscale(0, 10);
            StdDraw.show(0);
            point1.draw();
            point2.draw();
            point3.draw();
            point1.drawTo(point2);
            point2.drawTo(point3);
            point3.drawTo(point1);
            
            StdDraw.show(0);
            
            
        }
    }
        
    
}
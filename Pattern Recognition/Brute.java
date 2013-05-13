import java.util.Arrays;

public class Brute {
    public static void main(String[] args){
        String filename = args[0];
        
        In in = new In(filename);
        int N = in.readInt();
        Point stack[] = new Point[N];
        for (int i = 0; i<N ;i++){
            int x = in.readInt();
            int y = in.readInt();
            stack[i] = new Point(x, y);
        }
        
        Arrays.sort(stack);
        
        double mij;
        double mjk;
        double mkl;
        
        StdDraw.setXscale(0, 36000);
        StdDraw.setYscale(0, 36000);
        StdDraw.show(0);
        
        for (int i = 0; i<N; i++){
            for (int j=i+1; j<N; j++){
                mij = stack[i].slopeTo(stack[j]);
                for (int k=j+1; k<N; k++){
                    mjk = stack[j].slopeTo(stack[k]);
                    if (mij != mjk) continue;
                    for (int l=k+1; l<N; l++){
                        mkl = stack[k].slopeTo(stack[l]);
                        if (mjk != mkl) continue;
                        stack[i].draw();
                        stack[j].draw();
                        stack[k].draw();
                        stack[l].draw();
                        stack[i].drawTo(stack[l]);
                        StdDraw.show(0);
                    }
                }
            }
        }
    }
}
       

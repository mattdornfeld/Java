public class Percolation {
   // create N-by-N grid, with all sites blocked
  public int[][] Percolation(int N) {
     int grid[][]=new int [N][N];
        for (int i=1; i<=N; i++)
           for (int j=1; j<=N; j++)
              grid[j][i]=j-1+i;      
       
       return grid;
   }
  
 
  
  //public void open(int i, int j);         // open site (row i, column j) if it is not already
   //public boolean isOpen(int i, int j);    // is site (row i, column j) open?
   //public boolean isFull(int i, int j);    // is site (row i, column j) full?
   //public boolean percolates();            // does the system percolate?

   //public void main(){
     //System.out.print(percolation(5));
   //}
}


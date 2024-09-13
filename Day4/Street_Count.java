package Day4;

import java.util.*;

/*


5 5
1 1 1 0 1
0 0 1 1 0
0 1 0 1 1
0 1 1 1 0
1 1 0 0 0
0 0
4 0


1 -> indicates road and 0 -> indicates empty space
every turn indicates different street
find the minimum number of streets traveled in to reached end index from start index
in this case you travel through 7 streets to reach end index


1 1 1
    1 1
      1
  1 1 1
1 1


// op -> 7

 */

class Cell{
    int row;
    int col;
    int street;
    public Cell(int row, int col ,int street){
        this.row=row;
        this.col=col;
        this.street=street;
    }
}

public class Street_Count
{

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int matrix[][]= new int [r][c];
        boolean visited[][]=new boolean [r][c];
        for(int row=0;row<r;row++){
            for (int col=0;col<c;col++){
                matrix[row][col]=sc.nextInt();
            }
        }
        int strow=sc.nextInt();
        int stcol=sc.nextInt();
        int endrow=sc.nextInt();
        int endcol=sc.nextInt();
        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(strow,stcol,0));
        visited[strow][stcol]=true;
        while(!queue.isEmpty()){
            Cell curr=queue.poll();

            if(curr.row==endrow && curr.col==endcol){
                System.out.println(curr.street);
                break;
            }

            //Go left
            for(int col=curr.col-1;col>=0;col--){
                if(matrix[curr.row][col]==0 ||visited[curr.row][col]){
                    break;
                }
                queue.add(new Cell(curr.row,col, curr.street+1));
                visited[curr.row][col]=true;
            }
            //go right
            for(int col=curr.col+1;col<c;col++){
                if(matrix[curr.row][col]==0 || visited[curr.row][col]){
                    break;
                }
                queue.add(new Cell(curr.row,col,curr.street+1));
                visited[curr.row][col]=true;
            }
            //go up
            for (int row=curr.row-1;row>-0;row--){
                if(matrix[row][curr.col]==0 || visited[row][curr.col]){
                    break;
                }
                queue.add(new Cell(row,curr.col,curr.street+1));
                visited[row][curr.col]=true;
            }
            //Go Down
            for(int row=curr.row+1;row<r;row++){
                if(matrix[row][curr.col]==0 || visited [row][curr.col]){
                    break;
                }
                queue.add(new Cell(row,curr.col,curr.street+1));
                visited[row][curr.col]=true;

            }

        }
    }
}
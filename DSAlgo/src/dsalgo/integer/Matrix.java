package dsalgo.integer;

import java.util.Scanner;


public class Matrix {
	
	int matrix[][];
	//print cycle order r1[c1->c2], r1->r2[c2], r2[c2->c1], r2->r1[c1]
	public void print(int r1, int c1,int r2, int c2){
		if(c1==c2){
			//just print rows
			for(int i=r1;i<=r2;i++){
				System.out.println(matrix[i][c2]);
			}		
		}else if(r1==r2){
			//just print columns
			for(int i=c1;i<=c2;i++){
				System.out.println(matrix[r1][i]);
			}
		}else if(r1<r2 && c1<c2){
			//print rows and columns
			for(int i=c1;i<c2-1;i++){
				System.out.println(matrix[r1][i]);
			}
			for(int i=r1;i<=r2-1;i++){
				System.out.println(matrix[i][c2]);
			}		
	
			for(int i=c2;i>c1+1;i--){
				System.out.println(matrix[r2][i]);
			}
			
			for(int i=r2;i>=r1+1;i--){
				System.out.println(matrix[i][c1]);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Matrix m = new Matrix();
		
		String firstLine  = sc.nextLine().trim();
		String size[] = firstLine.split(" ");
		int rows = Integer.valueOf(size[0]);
		int cols = Integer.valueOf(size[1]);

		m.matrix = new int[rows][cols];
				
		for(int i =0; i <rows ; i++){
			String nextLine  = sc.nextLine().trim();
			String columns[] = nextLine.split(" ");
			if(columns.length!=cols){
				System.exit(-1);
			}
			for(int j=0;j<columns.length;j++){
				m.matrix[i][j] = Integer.valueOf(columns[j]);
			}
		}
		
		
		int endRow = rows-1;
		int endCol = cols-1;
		int stRow = 0; int stCol=0;
		while(stRow<=endRow && stCol<=endCol){
			m.print(stRow, stCol, endRow, endCol);
			stRow++;
			stCol++;
			endRow--;
			endCol--;
		}
	}
}

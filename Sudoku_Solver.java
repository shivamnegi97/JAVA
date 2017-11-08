package SudokuGen;

import java.util.Random;
import java.util.Scanner;

public class sudoku implements Runnable{
	static int a[][] = new int[9][9];
    static int b[][] = new int[9][9];
	
    Scanner Scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	sudoku s=new sudoku();
    	Thread t=new Thread(s);
   
    	System.out.println("|| Hey Lets Solve Sudoku ||\n\n");
    	
    	s.genrate(a, b);
    	
       t.start();
      
       

        }
    

public void display(){
    	for (int y = 0; y < 9; ++y) {
            if (y % 3 == 0)
                System.out.println("-------------------------");
            for (int z = 0; z < 9; ++z) {
                if (z % 3 == 0) System.out.print("| ");
                try {
					extracted();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          System.out.print(b[y][z] == 0
                                 ? " "
                                 : Integer.toString(b[y][z]));

                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println("-------------------------\n\n");
       
       
    }



	private void extracted() throws InterruptedException {
		Thread.currentThread();
		Thread.sleep(130);
	}
    
    
    
public  void genrate(int a[][],int b[][]){
	
	try
    {
    	
    
    Random r = new Random();
    int i1=r.nextInt(8);
    int firstval = i1;
    
        int x = firstval, v = 1;
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((x + j + v) <= 9)
                    a[i][j] = j + x + v;
                else
                    a[i][j] = j + x + v - 9;
                if (a[i][j] == 10)
                    a[i][j] = 1;
                // System.out.print(a[i][j]+" ");
            }
            x += 3;
            if (x >= 9)
                x = x - 9;
            // System.out.println();
            if (i == 2) {
                v = 2;
                x = firstval;
            }
            if (i == 5) {
                v = 3;
                x = firstval;
            }

        }
        int eorh;
        
        System.out.println("|| Hey Lets Solve Sudoku ||\n\n");
        System.out.println("\t|| Enter your Option ||\n" +
        		"\t\t1.Hard\n" +
        		"\t\t2.Easy");
        eorh = Scanner.nextInt();
        
        switch (eorh) {
        case 1:
            b[0][0] = a[0][0];
            b[8][8] = a[8][8];
         
            b[0][4] = a[0][4];
            b[1][2] = a[1][2];
           
           
           
            b[2][0] = a[2][0];
            b[2][4] = a[2][4];
        
            b[3][2] = a[3][2];
            b[3][8] = a[3][8];
            b[4][1] = a[4][1];
          
            b[4][5] = a[4][5];
            b[4][6] = a[4][6];
            b[5][0] = a[5][0];
         
            b[6][0] = a[6][0];
            b[6][2] = a[6][2];
         
            b[7][1] = a[7][1];
            b[7][2] = a[7][2];
           
            b[7][6] = a[7][6];
         
            b[8][5] = a[8][5];
        
         

            break;
        case 2:
            b[0][3] = a[0][3];
            
          
            b[1][3] = a[1][3];
            b[1][6] = a[1][6];
            b[1][7] = a[1][7];
            
            b[2][0] = a[2][0];
            b[2][6] = a[2][6];
            b[2][4] = a[2][4];
          
            b[3][2] = a[3][2];
       
            b[3][7] = a[3][7];
            b[4][0] = a[4][0];
          
            b[4][6] = a[4][6];
            b[4][4] = a[4][4];
          
            
            b[5][0] = a[5][0];
            b[5][6] = a[5][6];
            b[5][2] = a[5][2];
          
            b[6][0] = a[6][0];
            b[6][8] = a[6][8];
            b[6][6] = a[6][6];
            b[6][8] = a[6][8];
       
            b[7][1] = a[7][1];
            b[7][5] = a[7][5];
            b[7][3] = a[7][3];
          
         
           
            b[8][2] = a[8][2];
            b[8][6] = a[8][6];
            b[8][4] = a[8][4];
            
            break;
        default:
            System.out.println("Invalid Choice!");
            break;
        }   
    }
	
	catch(Exception e)
	{
        	
        
	}


}



public void run() {
	// TODO Auto-generated method stub
	
	display();
	 sudoku.solvePuzzle9(b);
	 display();
	
	 
}

public static boolean solvePuzzle9(int [][]b)
{
	int x=0,y=0;
	boolean found = false;
	for(x = 0;x < 9; x ++)
	{
		for(y = 0;y < 9; y++)
		{
			if(b[x][y] == 0)
			{
				found = true;
				break;
			}
		}
		if( found ) break;
	}
	if(!found) return true;
	
	boolean digits[] = new boolean[11];
	for(int i = 0; i < 9; i++)
	{
		digits[b[x][i]] = true;
		digits[b[i][y]] = true;
	}
	int bx = 3 * (x/3), by = 3 * (y/3);
	for(int i =0;i<3;i++)
		for(int j = 0; j < 3; j++)
			digits[b[bx+i][by+j]] = true;
	
	for(int i = 1 ; i <= 9; i++)
	{
		if(!digits[i] )
		{
			b[x][y] = i;
			if(solvePuzzle9(b))
				return true;
			b[x][y] = 0;
		}
	}
	return false;
}
}



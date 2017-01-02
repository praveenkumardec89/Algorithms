package com.praveen.machine.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class BotSavesPrincess {
	
	public static int princessPostionHorizantalIndex;
	public static int princessPostionVerticalIndex;
	
static void displayPathtoPrincess(int n, char[][] grid){
	int length = grid.length;
	princessPostionHorizantalIndex = n/2 +1;
	princessPostionVerticalIndex = n/2 +1;
			if(grid[0][0]=='p'){//left most
				while(princessPostionHorizantalIndex !=1 && princessPostionVerticalIndex !=1){					
					System.out.println("LEFT");
					System.out.println("UP");
					princessPostionHorizantalIndex -=1;
					princessPostionVerticalIndex -=1;
				}
				
			}else if(grid[0][length-1]=='p'){//top right
				while(princessPostionHorizantalIndex !=1 && princessPostionVerticalIndex !=length){					
					System.out.println("RIGHT");
					System.out.println("UP");
					princessPostionHorizantalIndex -=1;
					princessPostionVerticalIndex +=1;
				}
			}else if(grid[length-1][0]=='p'){//left bottom
				while(princessPostionHorizantalIndex !=length && princessPostionVerticalIndex !=1){					
					System.out.println("DOWN");
					System.out.println("LEFT");
					princessPostionHorizantalIndex +=1;
					princessPostionVerticalIndex -=1;
				}
			} else {//right bottom
				while(princessPostionHorizantalIndex !=1 && princessPostionVerticalIndex !=length){					
					System.out.println("DOWN");
					System.out.println("RIGHT");
					princessPostionHorizantalIndex +=1;
					princessPostionVerticalIndex +=1;
				}
				
			}

  }
public static void main(String[] args) throws NumberFormatException, IOException {
	  BufferedReader br = null;
	  br = new BufferedReader(new InputStreamReader(System.in));
        int m;
        m = Integer.parseInt(br.readLine());
        char grid[][] = new char[m][m];
        for(int i = 0; i < m; i++) {
        	String line = br.readLine();
        	for(int j=0;j<m;j++){
            grid[i][j] = line.charAt(j);
            grid[i][j] = line.charAt(j);
            grid[i][j] = line.charAt(j);
        }
        }
  //  checkForPrincessPostion(grid);
    displayPathtoPrincess(m,grid);
    }



}
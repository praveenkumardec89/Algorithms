/*Battleship is a popular 2 player game that takes place on a 10 x 10 board. Ships of various sizes are placed on the 10 x 10 board either horizontally or vertically. The position of the ships are hidden to the user. Your task is to sink all the ships.

Ships of the following size are given to each player.

Submarine (1 x 1) - 2 units
Destroyer (2 x 1) - 2 units
Cruiser (3 x 1) - 1 unit
Battleship(4 x 1) - 1 unit
Carrier (5 x 1) - 1 unit
In this version of the game, you will be playing solo. A testcase has a configuration of ship positions and your task is to destroy all the ships using the minimum number of moves.

Input Format

The first line contains N that denotes the size of the board. N lines follow, each containing 10 characters. 
If a cell is hit, it is denoted by character h (ascii value: 104). 
If a cell is a miss it is denoted by character m (ascii value: 109). 
If all the positions of a ship are destroyed, each of its position on the board is denoted by character d (ascii value: 100). 
If a cell is not attacked by the player, it is denoted by character - (ascii value: 45).

The board is indexed according to Matrix Convention.

Constraints

N = 10

Note 
Battleships can be touching each other.

Output Format

Output the cell to be hit in your current move. The output consists of two space separated integers R and C.

Sample Input

10
----------
----------
--------m-
----------
--d-----m-
---m-m----
------m---
-m---mm-h-
--m-------
------m---
Sample Output

7 9
*/


package com.praveen.machine.learning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;



public class Battleship1Player {
	public static boolean huntMode = true;
	public static int horizantalIndex;
	public static int verticalIndex;
	public static int m;
	public static  Random rn =null;
	public static String position;
	public static String filepath = "D:\\Users\\Public\\postions.txt";
	public static ArrayList<String> occupiedPositionList;
	public static ArrayList<String> shipPositionList;
	public static int hitCount =0;
	public static int destroyCount =0;
	public static int positionCheckCount =0;
	public static int damagedShipCount =0;
	
public static void main(String[] args) throws NumberFormatException, IOException {
	  BufferedReader br = null;
	  shipPositionList = new ArrayList<String>();
	  br = new BufferedReader(new InputStreamReader(System.in));
      //  int m;
        m = Integer.parseInt(br.readLine());
        char grid[][] = new char[m][m];
        for(int i = 0; i < m; i++) {
        	String line = br.readLine();
        	for(int j=0;j<m;j++){        		
            grid[i][j] = line.charAt(j);
            if(grid[i][j] =='h'){
            	huntMode = false;// you have hit a ship now stop hitting random points
            	//hit the surrounding positions to destroy the ship completely
            	// to decide weather to hit horizontally/vertically check the succeeding positions
            	shipPositionList.add(i+" "+j);
            	hitCount++;// to know how many hits been made for a ship
            	//writeThePositionInFile(i,j);
            	destroyCount++;
            }
            if((grid[i][j] =='d')||grid[i][j] =='m'){
            		destroyCount++;
            }
          
        }
        }//  you have to read the input each time as it is a sequential program
        // the input grid can be closed/open u need to store the state 
        
        // before performing any operation invalidate, do it only if destroyed at least one ship
        if(destroyCount>0){
        invalidatePositions(grid,grid.length);
        }
        if(huntMode){
        	//hit random positions till you find a ship
        	// but after finding the ships you have to be specific about these positions
        	//you have to invalidate the positions based on found ships
        	hitRandomPosition();
        	  
        	
        }else{
        	//found a ship now hit the position on basis of
        	//ship sizes and ships left to be destroyed
        	if(hitCount ==1){//more than one hits for a ship , so hit the same ship again
        		hitSurroundingPosition(shipPositionList,grid);        
        		
        	}else{//more than one hits on the ships
        		hitCount = shipPositionList.size();
        		//find out the direction of the hits
        		int initialIndex =Integer.parseInt(shipPositionList.get(0).split(" ")[0]);
        		int finalIndex =Integer.parseInt(shipPositionList.get(hitCount-1).split(" ")[0]);
        		if(initialIndex == finalIndex){//hits are horizontal
        			hitHorizantalSurroundingPosition(shipPositionList,grid);
        			
        		}else{// hits are vertical
        			
        			hitVerticalSurroundingPosition(shipPositionList,grid);
        			
        		}
        		
        	}
        	
        	
        }
       
    }

private static void invalidatePositions(char[][] grid, int length) {
	ArrayList<String> list = new ArrayList<>();
	 for(int i = 0; i < m; i++) {     	
     	for(int j=0;j<m;j++){ 
     		list.add(i+" "+j);
     			if((!(_theNextPositionOfHitIsAvailable(list, "right", grid, true)))
     					&&(!(_theNextPositionOfHitIsAvailable(list, "left", grid, true)))
     					&&(!(_theNextPositionOfHitIsAvailable(list, "up", grid, true)))
     					&&(!(_theNextPositionOfHitIsAvailable(list, "down", grid, true)))){
     					writeThePositionInFile(i, j);
     			}
     			list.clear();
     		}
     	}
	 }

private static void hitVerticalSurroundingPosition(ArrayList<String> shipPositionList2, char[][] grid) {

	int count = shipPositionList2.size();
	ArrayList<String> list = new ArrayList<String>();
	list.add(shipPositionList2.get(0));
	if(_theNextPositionOfHitIsAvailable(list,"up",grid, false)){//right position available
		String[] nextPosition = list.get(0).split(" ");
		int x= Integer.parseInt(nextPosition[0]);
		int y= Integer.parseInt(nextPosition[1]);
		if(!(checkIfThisPositionIsAlreadyHit(x-1, y)) && (positionCheckCount==0)){
			System.out.println((x-1)+" "+y);
			writeThePositionInFile(x-1,y);
			positionCheckCount++;
		}
	}
	list.clear();
	list.add(shipPositionList2.get(count-1));
	if(_theNextPositionOfHitIsAvailable(list,"down",grid, false)){//right position available
		String[] nextPosition = list.get(0).split(" ");
		int x= Integer.parseInt(nextPosition[0]);
		int y= Integer.parseInt(nextPosition[1]);
		if(!(checkIfThisPositionIsAlreadyHit(x+1, y)) && (positionCheckCount==0)){
			System.out.println((x+1)+" "+y);
			writeThePositionInFile(x+1,y);
			positionCheckCount++;
		}
	}
	
}

private static void hitHorizantalSurroundingPosition(ArrayList<String> shipPositionList2, char[][] grid) {
	int count = shipPositionList2.size();
	ArrayList<String> list = new ArrayList<String>();
	list.add(shipPositionList2.get(count -1));
	if(_theNextPositionOfHitIsAvailable(list,"right",grid, false)){//right position available
		String[] nextPosition = list.get(0).split(" ");
		int x= Integer.parseInt(nextPosition[0]);
		int y= Integer.parseInt(nextPosition[1]);
		if(!(checkIfThisPositionIsAlreadyHit(x, y+1)) && (positionCheckCount==0)){
			System.out.println(x+" "+(y+1));
			writeThePositionInFile(x,y+1);
			positionCheckCount++;
		}
	}
	list.clear();
	list.add(shipPositionList2.get(0));
	if(_theNextPositionOfHitIsAvailable(list,"left",grid, false)){//left position available
		String[] nextPosition = list.get(0).split(" ");
		int x= Integer.parseInt(nextPosition[0]);
		int y= Integer.parseInt(nextPosition[1]);
		if(!(checkIfThisPositionIsAlreadyHit(x, y-1)) && (positionCheckCount==0)){
			System.out.println(x+" "+(y-1));
			writeThePositionInFile(x,y-1);
			positionCheckCount++;
		}
	}
	
}

private static void hitSurroundingPosition(ArrayList<String> shipPositionList2, char[][] grid) {
	
	
	if(_theNextPositionOfHitIsAvailable(shipPositionList2,"right",grid, false)){//right position available
		String[] nextPosition = shipPositionList2.get(0).split(" ");
		int x= Integer.parseInt(nextPosition[0]);
		int y= Integer.parseInt(nextPosition[1]);
		if(!(checkIfThisPositionIsAlreadyHit(x, y+1)) && (positionCheckCount==0)){
			System.out.println(x+" "+(y+1));
			writeThePositionInFile(x,y+1);
			positionCheckCount++;
		}
		
	}
	if(_theNextPositionOfHitIsAvailable(shipPositionList2,"left",grid, false)){//left position available
		String[] nextPosition = shipPositionList2.get(0).split(" ");
		int x= Integer.parseInt(nextPosition[0]);
		int y= Integer.parseInt(nextPosition[1]);
		if(!(checkIfThisPositionIsAlreadyHit(x, y-1)) && (positionCheckCount==0)){
			System.out.println(x+" "+(y-1));
			writeThePositionInFile(x,y-1);
			positionCheckCount++;
		}
	}
	if(_theNextPositionOfHitIsAvailable(shipPositionList2,"up",grid, false)){
		String[] nextPosition = shipPositionList2.get(0).split(" ");
		int x= Integer.parseInt(nextPosition[0]);
		int y= Integer.parseInt(nextPosition[1]);
		if(!(checkIfThisPositionIsAlreadyHit(x-1, y)) && (positionCheckCount==0)){
			System.out.println((x-1)+" "+y);
			writeThePositionInFile(x-1,y);
			positionCheckCount++;
		}
	}
	if(_theNextPositionOfHitIsAvailable(shipPositionList2,"down",grid, false)){
		String[] nextPosition = shipPositionList2.get(0).split(" ");
		int x= Integer.parseInt(nextPosition[0]);
		int y= Integer.parseInt(nextPosition[1]);
		if(!(checkIfThisPositionIsAlreadyHit(x+1, y)) && (positionCheckCount==0)){
			System.out.println((x+1)+" "+y);
			writeThePositionInFile(x+1,y);
			positionCheckCount++;
		}
	}
	
}

private static boolean _theNextPositionOfHitIsAvailable(ArrayList<String> shipPositionList2, String string, char[][] grid,boolean invalidationIndicator) {
	// check if the next position is available to the right/left/up/down
	boolean available = false;
	String[] pos = shipPositionList2.get(0).split(" ");
	switch (string){
		case "right":
	        if((Integer.parseInt(pos[1])<9) ){//no right rows left
	        	if(invalidationIndicator){
	        		if((grid[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])+1] == '-')
	        				|| (grid[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])+1] == 'h') ){
			        	available = true;
			        }	
	        		
	        		
	        	}else{
	        	if(grid[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])+1] == '-'){
		        	available = true;
		        }
	        	}
	        }
			
	        break;
		case "left": 
			 if((Integer.parseInt(pos[1])>0) ){//no left rows left
				 if(invalidationIndicator){
					 if((grid[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])-1] == '-')
							 || (grid[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])-1] == 'h')){
				        	available = true;
				        }
					 
				 }else{
		        	if(grid[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])-1] == '-'){
			        	available = true;
			        }
				 }
		        }
	        break;
		case "up":
			 if((Integer.parseInt(pos[0])>0) ){
				 if(invalidationIndicator){
					 if((grid[Integer.parseInt(pos[0])-1][Integer.parseInt(pos[1])] == '-')
							 ||(grid[Integer.parseInt(pos[0])-1][Integer.parseInt(pos[1])] == 'h')){
				        	available = true;
				        }
				 }else{
		        	if(grid[Integer.parseInt(pos[0])-1][Integer.parseInt(pos[1])] == '-'){
			        	available = true;
			        }
				 }
		        }
	        break;
		case "down":        
			 if((Integer.parseInt(pos[0])<9) ){
				 if(invalidationIndicator){
					 if((grid[Integer.parseInt(pos[0])+1][Integer.parseInt(pos[1])] == '-')
							 ||(grid[Integer.parseInt(pos[0])+1][Integer.parseInt(pos[1])] == 'h')){
				        	available = true;
				        } 
				 }else{
		        	if(grid[Integer.parseInt(pos[0])+1][Integer.parseInt(pos[1])] == '-'){
			        	available = true;
			        }
				 }
		        }
	        break;
	       
		default:
	         // they are executed if none of the above case is satisfied
	        break;
	
	
	
	}

	return available;
}

public static void hitRandomPosition(){
	rn = new Random();//generate random vertices
	horizantalIndex = rn.nextInt(m);
	verticalIndex   = rn.nextInt(m);
	if(checkIfThisPositionIsAlreadyHit(horizantalIndex,verticalIndex)){
		hitRandomPosition();
	}else{
		System.out.println(horizantalIndex+" "+verticalIndex);//print the position
		writeThePositionInFile(horizantalIndex,verticalIndex);//record the position got hit, so u won't hit the same point again
		
		
	}
	
}

private static void writeThePositionInFile(int horizantalIndex2, int verticalIndex2) {
	try(FileWriter fw = new FileWriter(filepath, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		{
		    out.println(horizantalIndex2+""+verticalIndex2);
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	
}


private static boolean checkIfThisPositionIsAlreadyHit(int horizantalIndex2, int verticalIndex2) {
	position = horizantalIndex2+""+verticalIndex2;
	boolean exists = false;
	
	File f = new File(filepath);
	if(f.exists() && !f.isDirectory()) { // check if the file exists first 
	    // if the file dosn't exist no hits yet
		readFile(filepath);
		for(int i=0;i<occupiedPositionList.size();i++){
			if(occupiedPositionList.get(i).equalsIgnoreCase(position)){
				exists = true;
				break;
			}
		}
	}
	return exists;
	
}

public static ArrayList<String> readFile(String path) {	
	// read the file and add the positions got hit to the arraylist
	try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		String line;
		occupiedPositionList = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			occupiedPositionList.add(line);
		}

	} catch (IOException e) {
		e.printStackTrace();
	}
	return occupiedPositionList;

}




}

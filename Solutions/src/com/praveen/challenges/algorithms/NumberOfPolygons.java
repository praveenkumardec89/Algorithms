package com.praveen.challenges.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class NumberOfPolygons {
	
public static int numberOfSquares =0;
public static int numberOfRectangles =0;
public static int numberOfOtherPolygons =0;
		
	public static void main(String[] args) throws IOException {		
		
		     BufferedReader br = null;		  
		     ArrayList<Integer> inputList = new ArrayList<Integer>();
        	 br = new BufferedReader(new InputStreamReader(System.in));
    		 for(int i=0;i<5;i++){
    	        // inputList = new ArrayList<Integer>();
    			 String input = br.readLine();
            	 String[] split = input.split(" ");
    			 	   	 if(!input.isEmpty()){
    			 	   		for(int j=0;j<split.length;j++){
    			 	   			inputList.add(Integer.parseInt(split[j]));
    			 	   		}
    			 	   	 }
    			 	   	isRectangle(inputList);
    			 	   inputList.clear();// = null;
    	 		   }
    		 
	         System.out.print(numberOfSquares+" "+numberOfRectangles+" "+numberOfOtherPolygons);
	}

	private static void isRectangle(ArrayList<Integer> a) {
		if((a.get(0) > 0)&&(a.get(1) > 0)&&(a.get(2) > 0)&&(a.get(3) > 0)){
			if((a.get(0) == a.get(1))&&(a.get(0)==a.get(3))
					&&(a.get(0) ==a.get(2))){
				numberOfSquares++;
			}else if((a.get(0) ==a.get(2))&&(a.get(1)==a.get(3))&&(a.get(0) !=a.get(1))){
				
				numberOfRectangles++;
				
			}else{
				numberOfOtherPolygons++;
			}
			
			
		}else{
			numberOfOtherPolygons++;
		}
		
	}   
}

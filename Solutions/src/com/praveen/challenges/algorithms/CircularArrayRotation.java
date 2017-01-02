package com.praveen.challenges.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class CircularArrayRotation {
	

	private static int requiredSum;	
	private static int arrayLength;
	private static int count=0;
		
	public static void main(String[] args) throws IOException {		
		
		     BufferedReader br = null;		  
		     ArrayList<Integer> a = new ArrayList<Integer>();		  	   
	         br = new BufferedReader(new InputStreamReader(System.in));
	         requiredSum=Integer.parseInt(br.readLine());
	         arrayLength = Integer.parseInt(br.readLine());
	         for (int i=0;i<arrayLength;i++){
	        	 a.add(Integer.parseInt(br.readLine()));        	 
	         }
	                //starting from first element check for other elements if the sums equals the given sum 
	         		for (int i = 0; i < a.size(); i++){
	                    for (int j = i + 1; j < a.size(); j++){
	                        if ((a.get(i) + a.get(j) == requiredSum)){
	                            count++;
	         
	                        }
	            }
	        }
	         
	        System.out.println(count); 
	       
	}   
	
}

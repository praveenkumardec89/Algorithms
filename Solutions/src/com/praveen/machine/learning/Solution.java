package com.praveen.machine.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	
	public Solution(){
		//nothing
	}

	public static final int EARTH_RADIUS = 6371;
	
	private static int numberOfTagsRequired;
	//private  double distance;
	//private static double speed;
	public static void main(String[] args) throws IOException {		
		List<String> destinationList = new ArrayList<String>();
		  BufferedReader br = null;
		 br = new BufferedReader(new InputStreamReader(System.in));
		 for(int i=0;i<100;i++){
	           // 	inputList = new ArrayList<String>();
			 	   	 String input = br.readLine();
			 	   	 if(!input.isEmpty()){
			 	   	 destinationList.add(input); 
			 	   	 }else{
			 	   		break;
			 	   	 }
	            	
	 		   }
//		String strLine = "";
//		  try {
//		        // Get the object of DataInputStream
//		        InputStreamReader isr = new InputStreamReader(System.in);
//		        BufferedReader br = new BufferedReader(isr);
//		        String line = "";
//		        while ((line = br.readLine()) != null)
//		        	System.out.println(line);
//
//		        isr.close();
//		    } catch (IOException ioe) {
//		        ioe.printStackTrace();
//		    }
		//   List<Solution> guestList = new ArrayList<Solution>();
//		   List<String> destinationList = new ArrayList<String>();
//		   ArrayList<String> tagList = new ArrayList<String>();
//		   ArrayList<String> resultList = new ArrayList<String>();
//	         br = new BufferedReader(new InputStreamReader(System.in));
//	      //   numberOfTagsRequired=Integer.parseInt(br.readLine());
//	       //  br = new BufferedReader(new InputStreamReader(System.in));
//	        // String value=null;
//	       //  br.readLine();
//	      //   br = new BufferedReader(new FileReader("C:\\testing.txt"));
//	         String sCurrentLine;
//				while ((sCurrentLine = br.readLine()) != null) {
//					//System.out.println(sCurrentLine);
//					destinationList.add(sCurrentLine);
//				}
//
////	          while(br.ready()){
////	        	  String[] input=br.readLine().split(":");
////	        	destinationList.add(input[0]);
////	        	tagList.add(input[1]);
////	         		} 
////	          String[] input=br.readLine().split(":");
////	          destinationList.add(input[0]);
////	        	tagList.add(input[1]);
////	        //  destinationList.add(br.readLine().substring(0,br.readLine().indexOf(":") ));
	         for(int i=0;i<destinationList.size();i++){	            	
	            	System.out.println(destinationList.get(i));
	            }
	         // read the input now start processing  it
//	        // System.out.println(numberOfTagsRequired);
//	         System.out.println("amsterdam,paris:architecture,food,museums,shopping,walking");
//	         System.out.println("amsterdam,barcelona:architecture,food,nightlife,shopping");
//	         System.out.println("amsterdam,london:architecture,food,museums,nightlife");
//	         System.out.println("berlin,london:architecture,food,monuments,nightlife");
//	         System.out.println("london,paris:architecture,food,monuments,museums");
//	            	
	            }
	            
	            
	            
	}
	   




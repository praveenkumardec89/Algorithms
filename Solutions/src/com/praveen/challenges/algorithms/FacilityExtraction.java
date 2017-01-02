package com.praveen.challenges.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class FacilityExtraction {
	
	public FacilityExtraction(){
		//nothing
	}
	
	private static int numberOfHotels;
	//private  double distance;
	//private static double speed;
	public static void main(String[] args) throws IOException {		
		
		  BufferedReader br = null;
		//   List<Solution> guestList = new ArrayList<Solution>();
		   List<String> facilityList = new ArrayList<String>();
		   ArrayList<String> descriptionList = new ArrayList<String>();
		   ArrayList<String> resultList = new ArrayList<String>();
	         br = new BufferedReader(new InputStreamReader(System.in));
	            numberOfHotels=Integer.parseInt(br.readLine());
	            
	            for(int i=0;i<numberOfHotels;i++){
	           // 	inputList = new ArrayList<String>();
	            	 String input = br.readLine();
	            	 facilityList.add(input);
	 		   }
	        //    numberOfTestCases=Integer.parseInt(br.readLine());
	           // while (null != (br.readLine())){
	            	 String input = br.readLine();
	            	 descriptionList.add(input);
	            	//while(input.)
	            //}

//	            
	       
//	            
//	            for(int i=0;i<facilityList.size();i++){
//	            	System.out.println(facilityList.get(i));
//	            }
//	            for(int i=0;i<descriptionList.size();i++){
//	            	System.out.println(descriptionList.get(i));
//	            }
	            
	            for(int i=0;i<facilityList.size();i++){
	            //	resultList = new ArrayList<String>();
		        	for(int j=0;j<descriptionList.size();j++){
		        		
		        	//	if(descriptionList.get(j).contains(facilityList.get(i))){
		        		if(	Pattern.compile(Pattern.quote(facilityList.get(i)), Pattern.CASE_INSENSITIVE).matcher(descriptionList.get(j)).find()){
		        		//	System.out.println(facilityList.get(i));
		        			resultList.add(facilityList.get(i));
		        		//System.out.println(	Pattern.compile(Pattern.quote(facilityList.get(i)), Pattern.CASE_INSENSITIVE).matcher(descriptionList.get(j)).find());
		        		}
		        		
		        		
		        		
		        	}
		        }
	            
	            Collections.sort(resultList);
	            for(int i=0;i<resultList.size();i++){
	            	
	            	System.out.println(resultList.get(i));
	            	
	            }
	            
	            
	            
	}
	   
}



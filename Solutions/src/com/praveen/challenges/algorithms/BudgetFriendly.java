package com.praveen.challenges.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class BudgetFriendly {
	
	public BudgetFriendly(){
		//nothing
	}
	
	public BudgetFriendly(int id,int hotelprice, double hotelrating){
		this.hotelPrice=hotelprice;
		this.hotelScore =hotelrating;
		this.cityId =id;
	}

	public BudgetFriendly(int totalbudget, double hotelrating){
		this.totalBudget=totalbudget;
		this.totalHotelScore =hotelrating;
	//	this.cityId =id;
	}

	
	private static int numberOfHotels;
	private  static int userBudget;
	private static int  numberOfCities;
	private int  hotelPrice;
	private double  hotelScore;
	private int cityId;
	private int totalBudget;
	private double totalHotelScore;
	
	public static void main(String[] args) throws IOException {		
		
		  BufferedReader br = null;
		//   List<Solution> guestList = new ArrayList<Solution>();
		  ArrayList<BudgetFriendly> hotelList = new ArrayList<BudgetFriendly>();
		   ArrayList<Integer> numberOfHotelsList = new ArrayList<Integer>();
		   ArrayList<Double> resultList = new ArrayList<Double>();
	         br = new BufferedReader(new InputStreamReader(System.in));
	         	
	           String input=br.readLine();
	            String[] array = input.split(" ");
	            numberOfCities =Integer.parseInt(array[0]);
	            userBudget = Integer.parseInt(array[1]);
	            
	            for(int i=0;i<numberOfCities;i++){
	            	numberOfHotels =Integer.parseInt(br.readLine());
	            	numberOfHotelsList.add(numberOfHotels);
	            	 for(int j=0;j<numberOfHotels;j++){
	            		 String[] hotelinput = br.readLine().split(" ");
	            		// if((numberOfCities>1) &&( Integer.parseInt(hotelinput[0])>=userBudget)){
	            			 //nothing 
	            		 //}else{
	            			 BudgetFriendly s= new BudgetFriendly(i,Integer.parseInt(hotelinput[0]),Double.parseDouble( hotelinput[1]));
		            		 hotelList.add(s);
	            		 //}
	            		 
	            	 }      	 	 
	 		   }
	       printResults(numberOfHotelsList, hotelList, resultList);
	       if(resultList.isEmpty()){
	    	   System.out.println(-1);
	       }else{
	    	  
	    	   Collections.sort(resultList);
	            int l= resultList.size();
	            System.out.println(resultList.get(l-1));
	       }
	           
	            
	}
	
	   public static ArrayList<Double> printResults(ArrayList<Integer> numberOfHotelsList, ArrayList<BudgetFriendly> hotelList,  ArrayList<Double> resultList){
		
		   	int numberOfLoops = numberOfHotelsList.size();
		   switch(numberOfLoops) {
	         case 1 :
	            System.out.println("Excellent!"); 
	            break;
	         case 2 :
	        	    for(int i=0;i<numberOfHotelsList.get(0);i++){
		            	 for(int j=numberOfHotelsList.get(0);j<numberOfHotelsList.get(0)+numberOfHotelsList.get(1);j++){
		            		 double tt =hotelList.get(i).hotelScore+hotelList.get(j).hotelScore;
		            			int hs = hotelList.get(i).hotelPrice+hotelList.get(j).hotelPrice;
		            		if(hs <= userBudget){
		    	            			resultList.add((Math.round(tt*100.00)/100.00));
		            					
		            		} 
		            	 }
		            }
	        	    
		            break;
	         case 3 :
	        	    for(int i=0;i<numberOfHotelsList.get(0);i++){
		            	 for(int j=numberOfHotelsList.get(0);j<numberOfHotelsList.get(0)+numberOfHotelsList.get(1);j++){
		            		 for(int k=numberOfHotelsList.get(0)+numberOfHotelsList.get(1);k<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2);k++){
		            			 double tt =hotelList.get(i).hotelScore+hotelList.get(j).hotelScore+hotelList.get(k).hotelScore;
			            			int hs = hotelList.get(i).hotelPrice+hotelList.get(j).hotelPrice+hotelList.get(k).hotelPrice;
		            			 if(hs <= userBudget){
				    	            			resultList.add((Math.round(tt*100.00)/100.00));
				            		}  
		            		 }
		            		
		            	 }
		            }
	            break;
	         case 4 :
	        	 for(int i=0;i<numberOfHotelsList.get(0);i++){
	            	 for(int j=numberOfHotelsList.get(0);j<numberOfHotelsList.get(0)+numberOfHotelsList.get(1);j++){
	            		 for(int k=numberOfHotelsList.get(0)+numberOfHotelsList.get(1);k<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2);k++){
	            			 for(int l=numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2);l<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3);l++){
	            			 double tt =hotelList.get(i).hotelScore+hotelList.get(j).hotelScore+hotelList.get(k).hotelScore+hotelList.get(l).hotelScore;
		            			int hs = hotelList.get(i).hotelPrice+hotelList.get(j).hotelPrice+hotelList.get(k).hotelPrice+hotelList.get(l).hotelPrice;
	            			 if(hs <= userBudget){
			    	            			resultList.add((Math.round(tt*100.00)/100.00));
			            		}  
	            		 }
	            		
	            	 }
	            }
	        	 }
	        	 break;
	         case 5 :
	        	 for(int i=0;i<numberOfHotelsList.get(0);i++){
	            	 for(int j=numberOfHotelsList.get(0);j<numberOfHotelsList.get(0)+numberOfHotelsList.get(1);j++){
	            		 for(int k=numberOfHotelsList.get(0)+numberOfHotelsList.get(1);k<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2);k++){
	            			 for(int l=numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2);l<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3);l++){
	            				 for(int m=numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3);m<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3)+numberOfHotelsList.get(4);m++){
	            			 double tt =hotelList.get(i).hotelScore+hotelList.get(j).hotelScore+hotelList.get(k).hotelScore+hotelList.get(l).hotelScore+hotelList.get(m).hotelScore;
		            			int hs = hotelList.get(i).hotelPrice+hotelList.get(j).hotelPrice+hotelList.get(k).hotelPrice+hotelList.get(l).hotelPrice+hotelList.get(m).hotelPrice;
	            			 if(hs <= userBudget){
			    	            			resultList.add((Math.round(tt*100.00)/100.00));
			            		}  
	            		 }
	            		
	            	 }
	            }
	        	 }}
	            break;
	         case 6 :
	        	 for(int i=0;i<numberOfHotelsList.get(0);i++){
	            	 for(int j=numberOfHotelsList.get(0);j<numberOfHotelsList.get(0)+numberOfHotelsList.get(1);j++){
	            		 for(int k=numberOfHotelsList.get(0)+numberOfHotelsList.get(1);k<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2);k++){
	            			 for(int l=numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2);l<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3);l++){
	            				 for(int m=numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3);m<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3)+numberOfHotelsList.get(4);m++){
	            					 for(int n=numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3)+numberOfHotelsList.get(4);n<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3)+numberOfHotelsList.get(4)+numberOfHotelsList.get(5);n++){	            					 
	            						 double tt =hotelList.get(i).hotelScore+hotelList.get(j).hotelScore+hotelList.get(k).hotelScore+hotelList.get(l).hotelScore+hotelList.get(m).hotelScore+hotelList.get(n).hotelScore;
	            						 int hs = hotelList.get(i).hotelPrice+hotelList.get(j).hotelPrice+hotelList.get(k).hotelPrice+hotelList.get(l).hotelPrice+hotelList.get(m).hotelPrice+hotelList.get(n).hotelPrice;
	            						 	if(hs <= userBudget){
						    	            	resultList.add((Math.round(tt*100.00)/100.00));
						            		}  
	            		 }
	            		
	            	 }
	            }
	        	 }}}
	            break;
	         case 7 :
	        	 for(int i=0;i<numberOfHotelsList.get(0);i++){
	            	 for(int j=numberOfHotelsList.get(0);j<numberOfHotelsList.get(0)+numberOfHotelsList.get(1);j++){
	            		 for(int k=numberOfHotelsList.get(0)+numberOfHotelsList.get(1);k<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2);k++){
	            			 for(int l=numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2);l<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3);l++){
	            				 for(int m=numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3);m<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3)+numberOfHotelsList.get(4);m++){
	            					 for(int n=numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3)+numberOfHotelsList.get(4);n<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3)+numberOfHotelsList.get(4)+numberOfHotelsList.get(5);n++){
	            						 for(int o=numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3)+numberOfHotelsList.get(4)+numberOfHotelsList.get(5);o<numberOfHotelsList.get(0)+numberOfHotelsList.get(1)+numberOfHotelsList.get(2)+numberOfHotelsList.get(3)+numberOfHotelsList.get(4)+numberOfHotelsList.get(5)+numberOfHotelsList.get(6);o++){
	            							 double tt =hotelList.get(i).hotelScore+hotelList.get(j).hotelScore+hotelList.get(k).hotelScore+hotelList.get(l).hotelScore+hotelList.get(m).hotelScore+hotelList.get(n).hotelScore+hotelList.get(o).hotelScore;
	            							 int hs = hotelList.get(i).hotelPrice+hotelList.get(j).hotelPrice+hotelList.get(k).hotelPrice+hotelList.get(l).hotelPrice+hotelList.get(m).hotelPrice+hotelList.get(n).hotelPrice+hotelList.get(o).hotelPrice;
						            			 if(hs <= userBudget){
								    	            	resultList.add((Math.round(tt*100.00)/100.00));
								            		}  
	            		 }
	            		
	            	 }
	            }
	        	 }}}}
	            break;
	         case 8 :
	            //same as case7 with one more loop
	         case 9 :
	        	//same as case7 with one more loop
	            break;
	         case 10 :
	        	//same as case7 with one more loop
		            break;
	         default :
	            //nothing
	      }
		   
		   
		   return resultList;
       }
	   
}



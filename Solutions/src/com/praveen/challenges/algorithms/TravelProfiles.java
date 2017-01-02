package com.praveen.challenges.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




public class TravelProfiles {
	
	public TravelProfiles(){
		//nothing
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getHotelAveragePrice() {
		return hotelAveragePrice;
	}

	public void setHotelAveragePrice(int hotelAveragePrice) {
		this.hotelAveragePrice = hotelAveragePrice;
	}

	public ArrayList<String> getHotelFacilities() {
		return hotelFacilities;
	}

	public void setHotelFacilities(ArrayList<String> hotelFacilities) {
		this.hotelFacilities = hotelFacilities;
	}

	public int getNumberOfFacilities() {
		return numberOfFacilities;
	}

	public void setNumberOfFacilities(int numberOfFacilities) {
		this.numberOfFacilities = numberOfFacilities;
	}

	public int getMaximumBudget() {
		return maximumBudget;
	}

	public void setMaximumBudget(int maximumBudget) {
		this.maximumBudget = maximumBudget;
	}

	public ArrayList<String> getUserRequirements() {
		return userRequirements;
	}

	public void setUserRequirements(ArrayList<String> userRequirements) {
		this.userRequirements = userRequirements;
	}

	public TravelProfiles(int hid,int avgprc,ArrayList<String> inputList,int nfc) {
		
		this.hotelId=hid;
		this.hotelAveragePrice=avgprc;
		this.hotelFacilities=inputList;
		this.numberOfFacilities=nfc;
		
	}

	public TravelProfiles(int budget,ArrayList<String> inputList) {
		
		this.maximumBudget=budget;
		this.userRequirements=inputList;
		
	}
	public TravelProfiles(int hid, int nfc, int avgpc) {
		
		this.hotelId=hid;
		this.hotelAveragePrice=avgpc;
		this.numberOfFacilities=nfc;
		
	}


	public static final int EARTH_RADIUS = 6371;
	private int hotelId;
	private int hotelAveragePrice;
	private ArrayList<String> hotelFacilities;
	private int numberOfFacilities;
	
	private int maximumBudget;
	private ArrayList<String> userRequirements;	
	private static int numberOfTestCases;
	private static int numberOfHotels;
	//private  double distance;
	//private static double speed;
	public static void main(String[] args) throws IOException {
		
		
		  BufferedReader br = null;
		   List<TravelProfiles> guestList = new ArrayList<TravelProfiles>();
		   List<TravelProfiles> hotelList = new ArrayList<TravelProfiles>();
		   ArrayList<String> inputList = new ArrayList<String>();
		   ArrayList<TravelProfiles> resultList = new ArrayList<TravelProfiles>();
	         br = new BufferedReader(new InputStreamReader(System.in));
	            numberOfHotels=Integer.parseInt(br.readLine());
	            for(int i=0;i<numberOfHotels;i++){
	            	inputList = new ArrayList<String>();
	            	 String input = br.readLine();
	            	 String[] split = input.split(" ");
	            	 int hotid = Integer.parseInt(split[0]);
	            	 int avgp = Integer.parseInt(split[1]);
	            	 for(int k=2;k<split.length;k++){
	            		 inputList.add(split[k]);
	            	 }
	            	 int numfac = inputList.size();
	            	 TravelProfiles s= new TravelProfiles(hotid,avgp,inputList,numfac);
	            	 hotelList.add(s);
	 		   }
	            numberOfTestCases=Integer.parseInt(br.readLine());
//	            numberOfTestCases = in.nextInt();
	            for(int i=0;i<numberOfTestCases;i++){
	            	inputList = new ArrayList<String>();
	            	 String input = br.readLine();
	            	 String[] split = input.split(" ");
	            	 int naxb = Integer.parseInt(split[0]);
	            	 for(int m=1;m<split.length;m++){
	            		 inputList.add(split[m]);
	            	 }
	            	 TravelProfiles g= new TravelProfiles(naxb,inputList);
	            	 guestList.add(g);
	            	
	            }
            // input is read properly now start processing
	            //loop for each user/test cases over all the hotels 
	            //compare price and req vs facilities if both are a match then add the hotel id to the list
	            for(int i=0;i<guestList.size();i++){
	            	resultList = new ArrayList<TravelProfiles>();
		        	for(int j=0;j<hotelList.size();j++){
		        		
		        		if((guestList.get(i).maximumBudget >= hotelList.get(j).hotelAveragePrice) && facilityAvailable(guestList.get(i).userRequirements,hotelList.get(j).hotelFacilities)){
		        			//System.out.println(guestList.get(i).maximumBudget+" "+hotelList.get(j).hotelAveragePrice +" "+facilityAvailable(guestList.get(i).userRequirements,hotelList.get(j).hotelFacilities));
		        			TravelProfiles rgv= new TravelProfiles(hotelList.get(j).hotelId, hotelList.get(j).numberOfFacilities, hotelList.get(j).hotelAveragePrice);
		        			resultList.add(rgv);
		        			
		        		}
		        	}
		        	// print the results for each guest request
		        	printHotelList(resultList);
		        	System.out.println();
		        	resultList.clear();
		        	
		       }
	            
	}

	private static void printHotelList(ArrayList<TravelProfiles> resultList) {
		// they need to be ordered on the basis of 
		//number of facilities descending
		//price ascending
		//hotel id ascending
		order(resultList);
		for(int i=0;i<resultList.size();i++){
			System.out.print(resultList.get(i).getHotelId()+" ");
		}
		
	}

	private static boolean facilityAvailable(ArrayList<String> userRequirements2, ArrayList<String> hotelFacilities2) {
		
		return  hotelFacilities2.containsAll(userRequirements2);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void order(List<TravelProfiles> results) {

	    Collections.sort(results, new Comparator() {
	    //	public int compare(Solution o1, Solution o2) {}
	    	@Override
			public int compare(Object o1, Object o2) {


	        	Integer x1 = ((TravelProfiles) o1).getNumberOfFacilities();
	        	Integer x2 = ((TravelProfiles) o2).getNumberOfFacilities();
	            int sComp = x2.compareTo(x1);

	            if (sComp != 0) {
	               return sComp;
	            } else {
	               Integer y1 = ((TravelProfiles) o1).getHotelAveragePrice();
	               Integer y2 = ((TravelProfiles) o2).getHotelAveragePrice();
	               int comp2 = y1.compareTo(y2);
	               if(comp2 !=0){
	            	   return comp2;
	            	 
	               }else{
	            	   Integer z1 = ((TravelProfiles) o1).getHotelId();
		               Integer z2 = ((TravelProfiles) o2).getHotelId();
		               return  z1.compareTo(z2);
	            	   
	            	   
	            	   
	               }
	            }
	    
			}

			
			

	    });	
	}
	   
}



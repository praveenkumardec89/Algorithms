package com.praveen.challenges.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class NearbyAttractions {
	
	public NearbyAttractions(){
		//nothing
	}

	public NearbyAttractions(int attrId,double attrLatt,double attrLong) {
		
		this.attractionId=attrId;
		this.attractionLattitude=attrLatt;
		this.attractionLongitude=attrLong;
		
	}

	public NearbyAttractions(double hotelLatt,double hotelLong,String means,float f ) {
		
		this.hotelLattitude=hotelLatt;
		this.hotelLongitude=hotelLong;
		this.meansOfTransport=means;
		this.time=f;
	}


	
	public NearbyAttractions(double dist, int attractionId2) {
		this.distance=dist;
		this.attractionId=attractionId2;
	}



	public static final int EARTH_RADIUS = 6371;
	private int attractionId;
	private double attractionLattitude;
	private double attractionLongitude;
	private double distance;
	
	private double hotelLattitude;
	private double hotelLongitude;
	private String meansOfTransport;
	private  double time;
	private static  double timeToAttraction;
	private static int numberOfAtractions;
	private static int numberOfTestCases;
	//private  double distance;
	//private static double speed;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		
		  BufferedReader br = null;
		   List<NearbyAttractions> attactionList = new ArrayList<NearbyAttractions>();
		   List<NearbyAttractions> hotelList = new ArrayList<NearbyAttractions>();
		   ArrayList<NearbyAttractions> distanceList = new ArrayList<NearbyAttractions>();
	//	   List<String> attractionIdList = new ArrayList<String>();
	            br = new BufferedReader(new InputStreamReader(System.in));
	            numberOfAtractions=Integer.parseInt(br.readLine());
	            for(int i=0;i<numberOfAtractions;i++){
	            	 String input = br.readLine();
	            	 String[] split = input.split(" ");
	            	 NearbyAttractions s= new NearbyAttractions(Integer.parseInt(split[0]),degree2radians(Double.parseDouble(split[1])),degree2radians(Double.parseDouble(split[2])));
	            	 attactionList.add(s);
	 		   }
	            numberOfTestCases=Integer.parseInt(br.readLine());
//	            numberOfTestCases = in.nextInt();
	            for(int i=0;i<numberOfTestCases;i++){
	            	 String input = br.readLine();
	            	 String[] split = input.split(" ");
	            	 NearbyAttractions s= new NearbyAttractions(degree2radians(Double.parseDouble(split[0])), degree2radians(Double.parseDouble(split[1])),split[2], Float.parseFloat(split[3]) );
	            	 hotelList.add(s);
	            	
	            }
	  
	            //we need to consider the speed to calculate the time, so put them in a map
	            // now compute the distance from each hotel to all the attractions , 
	            //then add the attraction id, distance to new list to print later
	            @SuppressWarnings("rawtypes")
				HashMap transportToSpeed = new HashMap<>();
	            transportToSpeed.put("metro", 20);//kmph
	            transportToSpeed.put("bike", 15);
	            transportToSpeed.put("foot", 5);
	        //    HashMap finalMap = new HashMap<>();
	            
	          //  System.out.println(transportToSpeed.get("metro").toString());
	        for(int i=0;i<hotelList.size();i++){
	        	distanceList = new ArrayList<NearbyAttractions>();
	       
		        	for(int j=0;j<attactionList.size();j++){
		        		
		        		double distanceFromHotel =distanceFromHotelToAttraction(hotelList.get(i).hotelLattitude, hotelList.get(i).hotelLongitude, attactionList.get(j).attractionLattitude, attactionList.get(j).attractionLongitude);			
		        		
		        		timeToAttraction = distanceFromHotel/Double.parseDouble(transportToSpeed.get(hotelList.get(i).meansOfTransport).toString());
		        		
		        			if(timeToAttraction <= minuitesToHours(hotelList.get(i).time)){		        				
		        				 NearbyAttractions s=  new NearbyAttractions(distanceFromHotel, attactionList.get(j).attractionId);		        				
		        				 distanceList.add(s);
		        			}
		        		
		        		
		        	}
//		 	  	 printAttractions(distanceList, attractionIdList);
		        	printAttractions2(distanceList);
		 	  	 distanceList.clear();
//		 	  	 attractionIdList.clear();  	    
	        }
	}

	private static void printAttractions2(ArrayList<NearbyAttractions> dist) {
		
		
		//Collections.sort(distanceList,new Solution());
		//Collections.sort(distanceList);
		order(dist);
		 for(int i=0;i<dist.size();i++){
         	System.out.print(dist.get(i).attractionId+" ");
        }
		 System.out.println();
	
	}

	public static void printAttractions(ArrayList<Double> a,List<String> attraction){
		
		Collections.sort(a);
		Set<Double> distanceSet = new HashSet<Double>(a);
		if(distanceSet.size() < a.size()){
            /* There are duplicates write the logic to sort on attraction id */
			
			
			
        }else{// no duplicates, distances to attractions are unique	 
		for(int i=0;i<a.size();i++){
			for(int j=0;j<attraction.size();j++){
				if((attraction.get(j).substring(0,attraction.get(j).indexOf("/"))).equalsIgnoreCase(a.get(i).toString())){
					System.out.print(attraction.get(j).substring(attraction.get(j).indexOf("/")+1)+" ");					
				}				
			}		
		}
        }
	System.out.print("\n");	
	}
	
	public static double degree2radians(double degrees){		
		return (degrees*3.14159265359)/180;			
		
	}
	
	public static double distanceFromHotelToAttraction(double hLat, double hLong, double aLat, double aLong) {

	    return Math.round((((Math.acos( Math.sin( hLat ) * Math.sin( aLat ) +
	    		Math.cos( hLat ) * Math.cos( aLat ) *
	    		Math.cos( aLong - hLong) ) * EARTH_RADIUS)))*100.0)/100.0;
	}
	
	public static double minuitesToHours(double minuites){
		
		return Math.round( (minuites/60)*100.0)/100.0;
	}


	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void order(ArrayList<NearbyAttractions> results) {

	    Collections.sort(results, new Comparator() {
	    //	public int compare(Solution o1, Solution o2) {}
	    	@Override
			public int compare(Object o1, Object o2) {


	        	Double x1 = ((NearbyAttractions) o1).distance;
	        	Double x2 = ((NearbyAttractions) o2).distance;
	            int sComp = x1.compareTo(x2);

	            if (sComp != 0) {
	               return sComp;
	            } else {
	               Integer y1 = ((NearbyAttractions) o1).attractionId;
	               Integer y2 = ((NearbyAttractions) o2).attractionId;
	               return y1.compareTo(y2);
	               
	            }
	    
			}
	    });	
	}
	

	    }
	

	
	




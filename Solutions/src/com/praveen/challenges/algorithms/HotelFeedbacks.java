package com.praveen.challenges.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;






public class HotelFeedbacks {
	
	public HotelFeedbacks(){
		//nothing
	}

	
	public HotelFeedbacks(int id, int men){
		this.hotelId=id;
		this.mentions=men;
	}
	private int hotelId;
	private static String[] keyWords;
	private static int numberOfReviews;
	private static String[] reviews;
	private int mentions;
	
	
	public static void main(String[] args) throws IOException {		
		
		 BufferedReader br = null;
		
		 //reviews = new ArrayList<String>();
		   List<HotelFeedbacks> hotelList = new ArrayList<HotelFeedbacks>();
		   ArrayList<Integer> hotelIdList = new ArrayList<Integer>();
		   ArrayList<HotelFeedbacks> resultList = new ArrayList<HotelFeedbacks>();
	     // read the keywords to be searched 
		   br = new BufferedReader(new InputStreamReader(System.in));
	           keyWords=br.readLine().split(" ");
	              // check for number of reviews
	           numberOfReviews = Integer.parseInt(br.readLine());
	         
	            for(int i=0;i<numberOfReviews;i++){
	            	int count=0;	            	
	            	 int hid= Integer.parseInt(br.readLine());
	            	 if(i>0){
	            		 if(hotelHasAlreadyGotReview(hotelIdList, hid)){
	            			 
	            		 }else{
	            			 hotelIdList.add(hid);
	            		 }
	            		 
	            	 }else{
	            		 hotelIdList.add(hid);
	            	 }
	            	 
	            	 
	            	  reviews = br.readLine().split(" ");
	            	 // check for the keywords in this review and add the count to a list
	            	 for(int x=0;x<keyWords.length;x++){	            		 
	            		 for(int y=0;y<reviews.length;y++){
	 	            			if((keyWords[x].equalsIgnoreCase(reviews[y].replaceAll("[-+.^:,]",""))) ){	 	            				
	 	            				count++;
	 	            			}         		 
		            		 
		            	 }         		 
            	 }
	            	 if(count !=0){
            			 HotelFeedbacks s= new HotelFeedbacks(hid, count);
		            	 hotelList.add(s);  
            		 }
	            	 
	            	
	            		
	            	}
	            
	            for(int i=0;i<hotelIdList.size();i++){
	            	int count = 0;
	            	for(int j=0;j<hotelList.size();j++){
	            		if(hotelIdList.get(i) == hotelList.get(j).hotelId){		            		
		            		count=count+hotelList.get(j).mentions;
		            	}
	            	}
	            	if((count !=0) ){
	            		
           			 HotelFeedbacks s= new HotelFeedbacks(hotelIdList.get(i), count);
           			 resultList.add(s);  
           		 }
	            	
	            	
	            	
	            }
	           
	        	
	            SortHotelsOnNumberOfReviews(resultList);
	            for(int j=0;j<resultList.size();j++){
	        		System.out.print(resultList.get(j).hotelId+" ");
	        	}
	}    
	
	public static boolean hotelHasAlreadyGotReview(ArrayList<Integer> a, int key) {
	    int low = 0;
	    int high = a.size() -1;
	    int mid;
	    Collections.sort(a);
	    while (low <= high) {
	        mid = (low + high) / 2;
	        if (a.get(mid)> key) {
	            high = mid - 1;
	        } else if (a.get(mid) < key) {
	            low = mid + 1;
	        } else {
	            return true;
	        }
	    }
	    return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void SortHotelsOnNumberOfReviews(List<HotelFeedbacks> results) {

	    Collections.sort(results, new Comparator() {
	    	@Override
			public int compare(Object o1, Object o2) {
	        	Integer x1 = ((HotelFeedbacks) o1).mentions;
	        	Integer x2 = ((HotelFeedbacks) o2).mentions;
	            return x2.compareTo(x1);
			}
	    });	
	}
	


}




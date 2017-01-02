package com.praveen.challenges.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class DeltaEncoding {
	

		
	public static void main(String[] args) throws IOException {		
		
		     BufferedReader br = null;		  
		     ArrayList<Integer> a = new ArrayList<Integer>();
		     ArrayList<Integer> b = new ArrayList<Integer>();
		     ArrayList<Integer> c = new ArrayList<Integer>();
	         br = new BufferedReader(new InputStreamReader(System.in));
	         String input = br.readLine();
        	 String[] split = input.split(" ");
	         
	         for (int i=0;i<split.length;i++){
	        	 a.add(Integer.parseInt(split[i]));        	 
	         }
	         b.add(a.get(0));
	        for(int i=1;i<a.size();i++){// replace elements with substracted values
	        	b.add(a.get(i)-a.get(i-1));
	        	
	        }
	        for(int i=1;i<b.size();i++){//get the indexes where values is -127<=x<=127
	        	if((b.get(i).intValue() < -127) ||(b.get(i).intValue() > 127) ){
	        		c.add(i);
	        	}
	        }
	        for(int i=0;i<c.size();i++){//add -128 wherever the value is not not in the limit	        	
	        	b.add(c.get(i)+i, -128);	        	
	        }
	        for(int i=0;i<b.size();i++){	        	
	        	System.out.print(b.get(i)+" ");// print it in the single line
	        }
	}   
}

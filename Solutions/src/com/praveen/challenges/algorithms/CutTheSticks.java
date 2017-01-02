package com.praveen.challenges.algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CutTheSticks {
	private static int firstElelemnt=0;
	private static int arrayElement=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> stickList = new ArrayList<Integer>();
        int n = in.nextInt();
        
        for(int arr_i=0; arr_i < n; arr_i++){
        	stickList.add(in.nextInt());
        }
        Collections.sort(stickList);
        System.out.println(n);
        while(!stickList.isEmpty()){
        	//  System.out.println(stickList.size());
        	  firstElelemnt=stickList.get(0);
        for(int i=0;i<stickList.size();i++){
        	arrayElement=stickList.get(i);
        	stickList.set(i, arrayElement-firstElelemnt);      	
        	
        }
        for(int i=0;i<stickList.size();i++){
        	if(stickList.get(i) ==0){
        		stickList.remove(i);
        		i=i-1;
        	}
        	       	
        }
//      
//        for(int i=0;i<stickList.size();i++){
//        	System.out.print(stickList.get(i)+" ");      	
//        	
//        }
        if(stickList.size() !=0){
        	System.out.println(stickList.size());
        }
        
        }  
        
        
    }
}

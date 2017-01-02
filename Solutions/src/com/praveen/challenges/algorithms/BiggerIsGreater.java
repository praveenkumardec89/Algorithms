package com.praveen.challenges.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BiggerIsGreater {
	private static ArrayList<String> permutationList;

	public BiggerIsGreater() {
		
	}
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> stickList = new ArrayList<String>();
     //   ArrayList<String> permutationList = new ArrayList<String>();
        int n = in.nextInt();
        
        for(int arr_i=0; arr_i < n; arr_i++){
        	stickList.add(in.next());
        }
        //start processing 
      //  for(int i=0;i<stickList.size();i++){        	
        	permutation("", stickList.get(2));
        	Collections.sort(permutationList);
        	int y= permutationList.size();
        	for(int j=0;j<permutationList.size();j++){ 
        	System.out.print(permutationList.get(j)+" ");
        	}
        	
        	
     //   }
        
        
        
	}
	private static void permutation(String prefix, String str) {
		permutationList = new ArrayList<String>();
	    int n = str.length();
	    if (n == 0) permutationList.add(str+prefix);//System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

}

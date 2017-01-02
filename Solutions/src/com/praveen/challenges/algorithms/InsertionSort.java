package com.praveen.challenges.algorithms;

import java.util.Scanner;

public class InsertionSort {

	public InsertionSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	     Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] a = new  int[n];//in.nextInt();
	        //int q = in.nextInt();
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i]=in.nextInt();
	        }
	        //input is read
	        for(int i = 1;i<a.length;i++){	        	
	        int	x = a[i];	        
	        int	 j = i - 1;
	        	    while( j >= 0 && a[j] > x){
	        	        a[j+1] = a[j];
	        	        j = j - 1;
	        	    }
	        	    a[j+1] = x;
	        	    for(int k=0;k<a.length;k++){        	
	    	     		System.out.print(a[k]+" ");      	
	    	     	
	    	     }
	        	    System.out.println();

	        }
	        
	}

}

package com.praveen.challenges.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class InsertionSortPart1 {

    public static void main(String[] args) {
    	//  ArrayList<Integer> a = new ArrayList<Integer>();
    	  
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a= new int[n];
     //   int k = in.nextInt();
        //int q = in.nextInt();
        for(int a_i=0; a_i < n; a_i++){
            a[a_i]=in.nextInt();
        }
      
     //   Collections.sort(a);
        int y=a.length-1;
        int x= a[y];
        for(int j=y-1;j>=0;j--){
        	if(a[j]>x){        		
        		a[j+1]= a[j];
        		printList(a);
        		System.out.println();
        		
        	}else if(a[j]<=x){
        		a[j+1]=x;
        		printList(a);
        		System.out.println();
        	}
        }
    }
    
    public static void printList(int[] list){
    	 for(int i=0;i<list.length;i++){        	
     		System.out.print(list[i]+" ");      	
     	
     }
    	
    }
    
}

package com.praveen.challenges.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class FibonacciModified {
	public static BigInteger  t1,t2;
	static int n;

	public static void main(String[] args) throws IOException {
		 BufferedReader br = null;
		 
		 br = new BufferedReader(new InputStreamReader(System.in));
		String[] keyWords=br.readLine().split(" ");
		t1=BigInteger.valueOf(Integer.parseInt(keyWords[0]));
		t2=BigInteger.valueOf(Integer.parseInt(keyWords[1]));
		n=Integer.parseInt(keyWords[2]);
		//input is read now write the method to generate the series till the length
		//becomes equals to n
		//System.out.print(t1+" "+t2+" "+n);
		generateFibonacciSeries(t1,t2,n);
	}

	private static void generateFibonacciSeries(BigInteger t12, BigInteger t22, int n2) {
		ArrayList<BigInteger> seriesList = new ArrayList<BigInteger>();
		seriesList.add(t12);
		seriesList.add(t22);
			for(int i=2;i<n2;i++){
				BigInteger x= seriesList.get(i-1).multiply(seriesList.get(i-1));
				BigInteger y=x.add(seriesList.get(i-2));
				
				seriesList.add(y);				
			}

//			for(int i=0;i<seriesList.size();i++){
//				System.out.print(seriesList.get(i)+" ");
//			}
		System.out.println(seriesList.get(n-1));
		
	}

}

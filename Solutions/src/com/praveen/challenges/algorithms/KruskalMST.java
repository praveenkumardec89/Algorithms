package com.praveen.challenges.algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class KruskalMST {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        int e = scan.nextInt();
        int[] unionFind = new int[v];
        int[] sizes = new int[v];
        SortedMap<Integer, List<int[]>> distance = new TreeMap<>();
        int resultDistance = 0;
        
        //Initialize to self loops of size 1
        for(int i = 0; i < v; i ++){
            unionFind[i] = i;
            sizes[i] = 1;
        }
        
        //Save edges in sorted map
        for(int i = 0; i < e; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int r = scan.nextInt();
            List<int[]> edges = new ArrayList<int[]>();
            if(distance.get(r) != null){
                edges = distance.get(r);
            }
            edges.add(new int[]{x-1,y-1});
            distance.put(r,edges);
        }
        
        //Connect from smallest 
        for(Map.Entry<Integer, List<int[]>> entry : distance.entrySet()){
            int r = entry.getKey();
            List<int[]> edge = entry.getValue();
            for(int[] ed : edge){
                //Connect only if their roots are different and add distance to result
                if(!connected(ed[0],ed[1],unionFind)){
                    union(ed[0],ed[1],unionFind,sizes);
                    resultDistance += r;
                }
            }
        }
        
        System.out.println(resultDistance);
            
    }
    
    //Root of the set
    static int root(int x, int[] arr) {
        while(x != arr[x]){
            arr[x] = arr[arr[x]];
            x = arr[x];
        }
        return x;
    }
    
    //A node is in the same set if their roots are equals
    static boolean connected(int x, int y, int[] arr){
        return root(x,arr) == root(y,arr);
    }
    
    //Union smaller set to larger set and add its size
    static void union(int x, int y, int[] arr, int[] sz){
        int i = root(x, arr);
        int j = root(y, arr);
        if(sz[i] < sz[j]){
            arr[i] = j;
            sz[j] += sz[i];
        }
        else{
            arr[j] = i;
            sz[i] += sz[j];
        }
        arr[i] = j;
    }
    
}
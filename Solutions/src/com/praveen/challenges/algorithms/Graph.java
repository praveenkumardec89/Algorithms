package com.praveen.challenges.algorithms;

import java.io.*; 
import java.util.*; 
  
public class Graph 
{ 
	 int weight[][]	;
			 int visited[];
					 int d[];
							 int p[];
							 int v,e;
 public static void main(String args[])throws IOException 
 { 
  Graph g=new Graph(); 
  g.algo(); 
 } 
 void creategraph()throws IOException 
 { 
 int i,j,a,b,w; 
 BufferedReader in=new BufferedReader( new InputStreamReader(System.in)); 
 //System.out.println(“nEnter number of vertices :”); 
 
 String[] nodeEdge = in.readLine().split(" ");
 v=Integer.parseInt(nodeEdge[0]); 
 //System.out.print(“nEnter number of Edges :”); 
 e=Integer.parseInt(nodeEdge[1]); 
 weight=new int[e][e]; 
 visited=new int [e]; 
 d=new int[e]; 
 p=new int[e]; 

 
 for ( i=1;i<=v;i++) 
 for( j=1;j<=v;j++) 
 weight[i][j]=0; 
  
 for (i=1;i<=v;i++) 
 { 
 p[i]=visited[i]=0; 
 d[i]=32767; 
 } 
 for ( i=1;i<=e;i++) 
 { 
// System.out.print(“nEnter edge a,b and weight w :”); 
	 String[] abweight = in.readLine().split(" ");
 a=Integer.parseInt(abweight[0]); 
 b=Integer.parseInt(abweight[1]); 
 w=Integer.parseInt(abweight[2]); 
 weight[a][b]=weight[b][a]=w; 
 } 
  
 } 
  
 void algo ()throws IOException 
 { 
 creategraph(); 
 int current,total,mincost,i; 
 current=1;d[current]=0; 
 total=1; 
 visited[current]=1; 
 while(total!=v) 
 { 
 for (i=1;i<=v;i++) 
 { 
 if(weight[current][i]!=0) 
 if(visited[i]==0) 
 if(d[i]>weight[current][i]) 
 { 
 d[i]=weight[current][i]; 
 p[i]=current; 
 } 
 } 
 mincost=32767; 
 for (i=1;i<=v;i++) 
 { 
 if(visited[i]==0) 
 if(d[i]<mincost) 
 { 
 mincost=d[i]; 
 current=i; 
 } 
 } 
 visited[current]=1; 
 total++; 
 } 
 mincost=0; 
 for(i=1;i<=v;i++) 
 mincost=mincost+d[i]; 
 System.out.print(mincost); 
 //System.out.print(“n Minimum Spanning tree is”); 
  
// for(i=1;i<=v;i++) 
// //System.out.print("n vertex" +i+"is connected to"+p[i]); 
}

} 

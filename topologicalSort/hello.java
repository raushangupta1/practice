package hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.cert.CertPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;



public class hello {
	public static void main(String[] args) throws Exception{
		int N = 9;
		int K = 12;
		String[] dict = {"ajcdkalclhkalklkaffagc", "baehilhiadeeleggaddedfakelf", "bajeiicifhlaghjdjjkakfddelckhkkbiag", "didehekfdiibac", "edfkkfjfcacchaiblgbfikhekldejfkfabhbbhbkicfkeadlg", "ejjldh", "flaebkkkaikkebijhllbbalagaje", "ghjbckhidg", "jljee"};

		System.out.println(findOrder(dict,N,K));
	}
	//this function will return alphabets in ascending order
	 public static String findOrder(String [] dict, int N, int K)
	    {
	       String res = "";
	       Graph graph = new Graph(K);
	       for(int i=0;i<N-1;i++) {
	    	   String s1 = dict[i];
	    	   String s2 = dict[i+1];
	    	   for(int j=0;j<Math.min(s1.length(), s2.length());j++) {
	    		   if(s1.charAt(j)!=s2.charAt(j)) {
	    			   graph.addEdge(s1.charAt(j)-'a', s2.charAt(j)-'a');
	    			   break;
	    		   }
	    	   }
	       }
	       //we check if there is no cycle in graph
	       if(isCyclic(K,graph.graph)) return res;
	       boolean[] visited = new boolean[K];
	       Stack<Integer> st = new Stack<Integer>();
	       for(int i=0;i<K;i++) {
	    	   if(!visited[i]) {
	    		   graph.topologicalSort(i,visited,st);
	    	   }
	       }
	       
	       while(!st.isEmpty()) {
	    	   char ch = (char)(st.pop()+'a');
	    	   res+= ch +" ";
	       }
	       res.trim(); 
	        return res; 
	    }
    // this function will detect cycle in a directed graph.
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    	Graph graph = new Graph(V);
    	graph.graph = adj;
    	  boolean[] visited = new boolean[V];
    	  boolean[] rec = new boolean[V];

          for(int i=0;i<V;i++) {
       		 if(graph.detectCycle(i,visited,rec)) return true;
          }
        return false;
    }
}

package hello;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Graph {
	int V;
	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	Graph(int v){
		this.V = v;
		for(int i=0;i<v;i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	void addEdge(int u,int v) {
		graph.get(u).add(v);
	}
	public void topologicalSort(int v, boolean[] visited, Stack<Integer> st) {
		visited[v] = true;
		Iterator<Integer> itr = graph.get(v).iterator();
		while(itr.hasNext()) {
			int x = itr.next();
			if(!visited[x]) {
				topologicalSort(x,visited,st);
			}
		}
		st.add(v);
	}
	public boolean detectCycle(int n, boolean[] visited, boolean[] rec) {
		if(rec[n]) return true;
		if(visited[n]) return false;
		visited[n] = true;
		rec[n] = true;
		Iterator<Integer> itr = graph.get(n).iterator();
		while(itr.hasNext()) {
			int x = itr.next();
			if(detectCycle(x,visited,rec)) {
				return true;
			}
		}
		rec[n]=false;
		return false;
	}
}
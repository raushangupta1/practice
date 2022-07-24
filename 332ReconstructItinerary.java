package hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
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
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;



public class hello {
    public static void main(String args[] ) throws Exception {
    	String[][] arr = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
    	List<List<String>> tickets = new ArrayList<>();
    	for(String[] x : arr) {
    		tickets.add(new ArrayList<>(Arrays.asList(x)));
    	}
    	System.out.println(tickets);

    	System.out.println(findItinerary(tickets));
    }
    static HashMap<String,PriorityQueue<String>> map= new HashMap<>();
    static int ticketLen;
    public static List<String> findItinerary(List<List<String>> tickets) {
    	ticketLen = tickets.size()+1;
        List<String> res = new ArrayList<>();
        for(List<String> list:tickets) {
        	String source = list.get(0);
        	String dest = list.get(1);
        	if(map.containsKey(source)) {
        		PriorityQueue<String> q = map.get(source);
        		q.add(dest);
        		map.put(source, q);
        	} else {
        		PriorityQueue<String> q = new PriorityQueue<>();
        		q.add(dest);
        		map.put(source, q);
        	}
        }
        res.add("JFK");
        dfs("JFK",res);
        return res;
    }
    public static boolean dfs(String v,List<String> res) {
    	if(res.size()==ticketLen) return true;
    	if(!map.containsKey(v) || map.get(v).size() == 0) {
    		return false;
    	}
    	
    	PriorityQueue<String> q = map.get(v);
    	List<String> temp = new ArrayList<>();
    	temp.addAll(q);
        Collections.sort(temp);
    	Iterator<String> itr= temp.iterator();
    	while(itr.hasNext()) {
    		String t = itr.next();
    		q.remove(t);
    		map.put(v, q);
    		res.add(t);
    		if(dfs(t,res)) return true;
    		q.add(t);
    		map.put(v, q);
    		res.remove(res.size()-1);
    	}
    	return false;
    }
}

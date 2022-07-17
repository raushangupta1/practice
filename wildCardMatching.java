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
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;



public class hello {
    public static void main(String args[] ) throws Exception {
    	String s = "";
    	String p = "*****";
    	System.out.println(isMatch(s,p));
    }
    
    public static boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0){
            return true;
        } else if(p.length()==0){
            return false;
        }
    	char[] pattern = p.toCharArray();
    	int index = 0;
    	boolean isFirst = true;
    	for(int i=0;i<pattern.length;i++) {
    		if(pattern[i]=='*') {
    			if(isFirst) {
    				pattern[index++] = pattern[i];
    				isFirst = false;
    			}
    		} else {
    			pattern[index++] = pattern[i];
    			isFirst = true;
    		}
    	}
    	p = "";
    	for(int i=0;i<index;i++) {
    		p += pattern[i];
    	}

    	boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    	dp[0][0] = true;
    	if(p.charAt(0)=='*') {
    		dp[0][1] = true;
    	}
    	for(int i=1;i<dp.length;i++) {
    		for(int j=1;j<p.length()+1;j++) {
    			if(p.charAt(j-1)=='?' || s.charAt(i-1)==p.charAt(j-1) ) {
    				dp[i][j] = dp[i-1][j-1];
    			} else if(p.charAt(j-1)=='*') {
    				dp[i][j] = dp[i-1][j] || dp[i][j-1];
    			}
    		}
    	}
    	
        return dp[s.length()][p.length()];
    }

    
}

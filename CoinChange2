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
import java.util.TreeMap;
import java.util.stream.Collectors;



public class hello {
    public static void main(String args[] ) throws Exception {
    	int[] coins = {1,2,5};
    	int amount = 5;
    	System.out.println(change(amount,coins));
    }
    public static int change(int amount, int[] coins) {
    	if(coins.length==0) return 0;
    	int[][] dp = new int[coins.length][amount+1];
    	for(int i=0;i<dp.length;i++) {
    		dp[i][0] = 1;
    	}

    	for(int i=1;i<dp[0].length;i++) {
    		if(i>=coins[0]) {
    		dp[0][i] = dp[0][i-coins[0]];
    		}
    	}
    	for(int i=1;i<dp.length;i++) {
    		for(int j=1;j<dp[0].length;j++) {
    			if(j>=coins[i]) {
    				dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
    			} else {
    				dp[i][j] = dp[i-1][j];
    			}
    		}
    	}
    	return dp[dp.length-1][dp[0].length-1];
        
    }
    // recursive approach for better understanding
    public static int changeRec(int amount, int[] coins) {
    	return changeCount(coins,amount,coins.length-1);
        
    }
	private static int changeCount(int[] coins, int amount, int index) {
		if(amount==0) return 1;
		if(index<0 || amount<0) return 0;
		
		return changeCount(coins,amount-coins[index],index)+changeCount(coins,amount,index-1);
		
	}
    
}

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
    	int[] coins = {186,419,83,408};
    	int amount = 6249;
    	System.out.println(coinChange(coins,amount));
    }
    static int minCount = Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
    	int R = coins.length+1;
    	int C = amount+1;
    	int[][] dp = new int[R][C];
    	for(int i=0;i<R;i++) {
    		for(int j=0;j<C;j++) {
    			if(j==0) dp[i][j] = 0;
    			if(i==0) dp[i][j] = Integer.MAX_VALUE-1;
    			if(i==1) {
    				dp[i][j] = j%coins[i-1]==0 ? j/coins[i-1]:Integer.MAX_VALUE-1;
    			}
    		}
    	}
    	for(int i=1;i<R;i++) {
    		for(int j=1;j<C;j++) {
    			if(j>=coins[i-1]) {
    				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
    			} else {
    				dp[i][j] = dp[i-1][j];
    			}
    		}
    	}

    	return dp[R-1][C-1]==Integer.MAX_VALUE-1 ? -1 : dp[R-1][C-1];
    }
    
    public static int coinChangeRec(int[] coins, int amount) {
    	changeCount(coins,amount,coins.length-1,0);
        return minCount == Integer.MAX_VALUE ? -1:minCount;
    }

	private static void changeCount(int[] coins, int amount, int index,int count) {
		if(amount==0) {
			if(count<minCount) {
				minCount = count;
			}
			return;
		}
		if(index<0 || amount<0) return;
		changeCount(coins,amount-coins[index],index,count+1);
		changeCount(coins,amount,index-1,count);
		
	}
    
}

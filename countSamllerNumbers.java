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
        int[] arr = {5,2,6,1};
    	System.out.println(countSmaller(arr));
    }
    static int[] count;
    public static List<Integer> countSmaller(int[] nums) {
    	List<Integer> res = new ArrayList<>();
    	count = new int[nums.length];
    	int[] originalIndex = new int[nums.length];
    	for(int i=0;i<nums.length;i++) {
    		originalIndex[i] = i;
    	}
    	sort(nums,0,nums.length-1,originalIndex);
    	for(int x:count) {
    		res.add(x);
    	}
        return res;
    }
	private static void sort(int[] nums, int left, int right, int[] originalIndex) {
		if(left<right) {
			int mid = (left+right)/2;
			sort(nums,left,mid,originalIndex);
			sort(nums,mid+1,right,originalIndex);
			merge(nums,left,mid,right,originalIndex);
		}
		return;
	}
	private static void merge(int[] nums, int left, int mid, int right,int[] originalIndex) {
		int l_len = mid-left+1;
		int r_len = right-mid;
		
		int[] l_arr = new int[l_len];
		int[] r_arr = new int[r_len];
		
		for(int i=0;i<l_len;i++) {
			l_arr[i] = originalIndex[left+i];
		}
		
		for(int i=0;i<r_len;i++) {
			r_arr[i] = originalIndex[i+mid+1];
		}
		
		int i=0,j=0,k=left,rightCount = 0;
		while(i<l_len && j<r_len) {
			if(nums[l_arr[i]]<=nums[r_arr[j]]) {
				originalIndex[k] = l_arr[i];
				count[l_arr[i]] += rightCount;
				i++;
			} else {
				originalIndex[k] = r_arr[j];
				rightCount++;
				j++;
			}
			k++;
		}
		while(i<l_len) {
			originalIndex[k] = l_arr[i];
			count[l_arr[i]] += rightCount;
			i++;
			k++;
		}
		while(j<r_len) {
			originalIndex[k] = r_arr[j];
			j++;
			k++;
		}
		
	}
    
}

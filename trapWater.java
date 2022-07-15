package practice;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Main {

    public static void main(String args[] ) throws Exception {
        int[] s = {0,1,0,2,1,0,1,3,2,1,2,1};
       
        
    	System.out.println(trap(s));
    }
    public static int trap(int[] height) {
        int res = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for(int i=0;i<height.length;i++){
            max_left[i] = i==0 ? height[i]:Math.max(height[i], max_left[i-1]);
        }
        for(int i = height.length-1;i>=0;i--){
            max_right[i] = i==height.length-1 ? height[i]: Math.max(height[i], max_right[i+1]);
        }
        for(int i=0;i<height.length;i++){
            res = (Math.min(max_left[i], max_right[i])-height[i]) >0 ?  (Math.min(max_left[i], max_right[i])-height[i])+res:  res;
        }
        return res;        
    }
}



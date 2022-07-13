package practice.maxRectangle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Main {

    public static void main(String args[] ) throws Exception {
        char[][] s = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
       
        
    	System.out.println(maximalRectangle(s));
    }
    public static int maximalRectangle(char[][] matrix) {
        int area = -1;
        int[] dp = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    dp[j]=0;
                } else{
                    dp[j] = dp[j]+1;
                }
            }
        int currArea = maxHistogram(dp);
        if(currArea>area) area = currArea;
        }
        return area;
    }

    public static int maxHistogram(int[] arr) {
        int area = 0;
        int currArea=0;
        Stack<Integer> st = new Stack<Integer>();
        int i;
        for( i=0;i<arr.length;){
            if(st.isEmpty()|| arr[st.peek()]<=arr[i]){
                st.add(i++);
            } else{
                int top = st.pop();
                if(st.isEmpty()){
                     currArea = i*arr[top];
                } else{
                     currArea = arr[top]*(i-st.peek()-1);
                }
                if(currArea>area) area = currArea;
            }
        }
        while(!st.isEmpty()){
            int top = st.pop();
            if(st.isEmpty()){
                currArea = i*arr[top];
            } else{
                currArea = arr[top]*(i-st.peek()-1);
            }
            if(currArea>area) area = currArea;
        }
        return area;
    }

}
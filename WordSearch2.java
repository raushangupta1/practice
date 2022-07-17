package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearch2 {
    public static void main(String args[] ) throws Exception {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
    	System.out.println(findWords(board,words));
    }

    static class TrieNode{
        Map<Character,TrieNode> map = new HashMap<>();
        boolean isWord = false;
    }
     static TrieNode trie = new  TrieNode();
    private static void addToTrie(String s){
        char[] arr = s.toCharArray();
        TrieNode curr = trie;
        for(char c :arr){
            if(!curr.map.containsKey(c)){
                curr.map.put(c, new TrieNode());
            }
            curr = curr.map.get(c);
        }
        curr.isWord = true;
    }
    private static void checkWord(char[][] board,int i,int j,Set<String> res,boolean[][] visited, TrieNode curr,String word){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length||visited[i][j] || !curr.map.containsKey(board[i][j])){
            return;
        }
        word += board[i][j];
        curr = curr.map.get(board[i][j]);
        visited[i][j] = true;
        if(curr.isWord){
            res.add(word);
        }
        
        checkWord(board,i+1,j,res,visited,curr,word);
        checkWord(board,i-1,j,res,visited,curr,word);
        checkWord(board,i,j+1,res,visited,curr,word);
        checkWord(board,i,j-1,res,visited,curr,word);
        visited[i][j] = false;
        return;
    }


    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        for(String s : words){
            addToTrie(s);
        }

        TrieNode curr = trie;
       
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
            	 boolean[][] visited = new boolean[board.length][board[0].length];
                checkWord(board,i,j,res,visited,curr,"");
            }
        }
        return new ArrayList<String>(res);
    }
	
    
}

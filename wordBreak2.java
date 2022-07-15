package practice;




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Main {

    public static void main(String args[] ) throws Exception {
        String s = "catsanddog";
        System.out.println(s.substring(0,2));
        List<String> dict = Arrays.asList(new String[]{"cat","cats","and","sand","dog"});

        
    	System.out.println(wordBreak(s,dict));
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        BreakWord(s,wordDict,res,0,new ArrayList<String>());
        return res;
    }
    public static void BreakWord(String word,List<String> wordDict,List<String> res,int i,List<String> list){
        if(word==""){
            res.add(String.join(" ", list));
            return;
        }
        if(i==word.length()+1){
            return;
        }
        String tempStr = word.substring(0, i);
        if(wordDict.contains(tempStr)){
            list.add(tempStr);
            word = word.substring(i,word.length());
            BreakWord(word,wordDict,res,0,list);
            word = tempStr+word;
            list.remove(list.size()-1);
            BreakWord(word,wordDict,res,i+1,list);
        } else{
            BreakWord(word,wordDict,res,i+1,list);
        }
        return;
    }


}

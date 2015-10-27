// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String S, String T) {
        // write your code in Java SE 8
        if(S == null && T == null){
            return "NOTHING";
        }

        if(S == null || T == null){
            return "IMPOSSIBLE";
        }

        if(S.equals(T)){
            return "NOTHING";
        }

        //Case: INSERT
        if(S.length() == T.length()-1){
            StringBuffer sb = new StringBuffer(S);
            char ch = 'a';
            for(int i = 0; i< T.length(); i++){
                if( i>=S.length() || T.charAt(i) != S.charAt(i)){
                    ch = T.charAt(i);
                    sb.insert(i, ch);
                    break;
                }
            }
            if(sb.toString().equals(T)){
                return "INSERT "+ch;
            }
        }

        //Case: DELETE
        if(S.length() == T.length()+1){
            StringBuffer sb = new StringBuffer(T);
            char ch = 'a';
            for(int i = 0; i< S.length(); i++){
                if( i>=T.length() || T.charAt(i) != S.charAt(i)){
                    ch = S.charAt(i);
                    sb.insert(i, ch);
                    break;
                }
            }
            if(sb.toString().equals(S)){
                return "DELETE "+ch;
            }
        }

        //Case: SWAP
        if(S.length() == T.length()){
            //If signature is same and the number of character difference is 2
            char[] s = S.toCharArray();
            char[] t = T.toCharArray();

            Arrays.sort(s);
            Arrays.sort(t);
            boolean signature = true;
            for(int i=0; i<s.length; i++){
                if(s[i] != t[i]){
                    signature = false;
                }
            }

            char[] arr= new char[2];
            int diff = 0;
            if(signature){
                for(int i=0; i<S.length(); i++){
                    if(T.charAt(i) != S.charAt(i)){
                        if(diff<2){
                            arr[diff] = S.charAt(i);
                        }
                        diff = diff +1;
                    }
                }
                if(diff==2){
                    return "SWAP " + arr[0] + " " + arr[1];
                }
            }
        }



        return "IMPOSSIBLE";
    }
}
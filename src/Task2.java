// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int n=1;
        long ans = 0;
        for(int i=1; i<A.length; i++){
            if(A[i-1] == A[i]){
                n++;
            }else{
                ans = ans + ((n*(n-1))/2);
                if(ans > 1000000000)
                    return 1000000000;
                n = 1;
            }
        }

        ans = ans + ((n*(n-1))/2);
        if(ans > 1000000000)
            return 1000000000;
        else
            return (int)ans;
    }
}
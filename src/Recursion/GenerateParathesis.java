package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParathesis {
    static void solve(int open, int close, String curr, List<String> ans){
        if(close==0){
            ans.add(curr);
            return;
        }
        if(open > 0){
            solve(open-1, close, curr+"(", ans);
        }
        if(close > 0 && close > open){
            solve(open, close-1, curr+")", ans);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, n, "", ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
}

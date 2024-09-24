package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    static void solve(int ind, String digits, String [] arr, String path, List<String> ans){
        if(ind==digits.length()){
            ans.add(path);
            return;
        }
        int digit = digits.charAt(ind)-'0';
        for(char c: arr[digit].toCharArray()){
            path+=c;
            solve(ind+1, digits, arr, path, ans);
            path = path.substring(0, path.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String [] arr = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
       List<String> ans = new ArrayList<>();
       if(digits.equals(""))
           return ans;
        solve(0, digits, arr, "", ans);
        return ans;
    }
}

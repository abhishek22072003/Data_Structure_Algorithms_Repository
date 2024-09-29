package Recursion;

import java.util.ArrayList;

public class PalindromePartitioning {
    static void partition(ArrayList<String> list){
        String last = list.get(list.size()-1);
        list.remove(list.size()-1);
        for(int i = 1; i <= list.size(); i++){
            String first = last.substring(0, i);
            String second = last.substring(i);
            if(isPalindrome(first)){
                list.add(first);
                list.add(second);
                partition(list);
            }else{
                return;
            }
        }
    }

    private static boolean isPalindrome(String first) {
        int start =0;
        int end = first.length()-1;
        while(start < end){
            if(first.charAt(start)!=first.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabaa";
        ArrayList<String> list = new ArrayList<>();
        list.add(s);
        partition(list);
    }
}

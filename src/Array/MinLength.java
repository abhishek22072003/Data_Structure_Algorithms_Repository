package Array;

import java.util.Stack;

public class MinLength {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='B'|| c=='D'){
                if(!st.isEmpty() && c=='B' && st.peek()=='A'){
                    st.pop();
                }
                else if(!st.isEmpty() && c=='D' && st.peek()=='C'){
                    st.pop();
                }else{
                    st.push(c);
                }
            }else{
                st.push(c);
            }
        }
        return st.size();
    }
}

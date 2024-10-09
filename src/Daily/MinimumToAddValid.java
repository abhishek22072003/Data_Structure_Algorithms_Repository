package Daily;

public class MinimumToAddValid {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int a = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                ans++;
            }else{
                if(ans > 0)
                    ans--;
                else
                    a++;
            }
        }
        return ans+a;
    }
}

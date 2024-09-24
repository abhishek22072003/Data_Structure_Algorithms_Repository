package Recursion;
// generate all binary string without consecative 1's present in string
public class AllBinaryString {
    static void solve(String curr, int ind, int size){
        if(ind == size){
            System.out.println(curr);
            return;
        }
        if(ind==0){
            solve(curr+"1", ind+1, size);
            solve(curr+"0", ind+1, size);
        }
        else {
            if(curr.charAt(curr.length()-1)=='1'){
                solve(curr+"0", ind+1, size);
            }else{
                solve(curr+"1", ind+1, size);
                solve(curr+"0", ind+1, size);
            }
        }
    }
    public static void main(String[] args) {
        int k = 4;
        solve("", 0, k);
    }
}

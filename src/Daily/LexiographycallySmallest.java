package Daily;

import java.util.ArrayList;

public class LexiographycallySmallest {
    static void solve(boolean taken, int ind1, int ind2, String word1, String word2, ArrayList<Integer> indices,  ArrayList<ArrayList<Integer>> ans){
        if(ind2 == word2.length()){
            ans.add(new ArrayList<>(indices));
            return;
        }
        if(ind1==word1.length()){
            return;
        }
        if(taken){
            if(word1.charAt(ind1)==word2.charAt(ind2)){
                indices.add(ind1);
                solve(true, ind1+1, ind2+1, word1, word2, indices,ans);
                indices.remove(indices.size()-1);
            }
        }
        else{
            if(word1.charAt(ind1)==word2.charAt(ind2)){
                indices.add(ind1);
                solve(false, ind1+1, ind2+1, word1, word2, indices, ans);
                indices.remove(indices.size()-1);
            }else{
                indices.add(ind1);
                solve(true, ind1+1, ind2+1, word1, word2, indices, ans);
                indices.remove(indices.size()-1);
            }
        }
        solve(taken, ind1+1, ind2, word1, word2, indices, ans);
    }
    public static int[] validSequence(String word1, String word2) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(false, 0, 0, word1, word2, new ArrayList<Integer>(), ans);
        int [] res;
        if(ans.size() > 0){
            res = new int[ans.get(0).size()];
            for(int i = 0; i<res.length; i++)
                res[i] = ans.get(0).get(i);
            return res;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "ab";
        System.out.println(validSequence(word1, word2));
    }
}

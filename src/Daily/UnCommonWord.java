package Daily;

import java.util.ArrayList;
import java.util.HashMap;

public class UnCommonWord {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String ,Integer> map = new HashMap<>();
        for(String s: s1.split(" ")){
            if(map.containsKey(s))
                map.put(s, map.get(s)+1);
            else
                map.put(s, 1);
        }
        for(String s: s2.split(" ")){
            if(map.containsKey(s))
                map.put(s, map.get(s)+1);
            else
                map.put(s, 1);
        }
        ArrayList<String> list  = new ArrayList<>();
        for(String s: map.keySet()){
            if(map.get(s)==1)
                list.add(s);
        }
        String [] ans = new String[list.size()];
        for(int i  = 0; i<ans.length; i++)
            ans[i] = list.get(i);
        return ans;
    }
}

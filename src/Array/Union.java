package Array;

import java.util.ArrayList;

public class Union{
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> union = new ArrayList<>();

        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < arr1.length && ptr2 < arr2.length){
            if(arr1[ptr1] < arr2[ptr2]){
                if(union.size()==0)
                    union.add(arr1[ptr1]);
                else if(union.get(union.size()-1)!=arr1[ptr1])
                    union.add(arr1[ptr1]);
                ptr1++;
            }else{
                if(union.size()==0)
                    union.add(arr2[ptr2]);
                else if(union.get(union.size()-1)!=arr2[ptr2])
                    union.add(arr2[ptr2]);
                ptr2++;
            }
        }
        while(ptr1 < arr1.length){
            if(union.size()==0)
                union.add(arr1[ptr1]);
            else if(union.get(union.size()-1)!=arr1[ptr1])
                union.add(arr1[ptr1]);
            ptr1++;
        }
        while(ptr2 < arr2.length){
            if(union.size()==0)
                union.add(arr2[ptr2]);
            else if(union.get(union.size()-1)!=arr2[ptr2])
                union.add(arr2[ptr2]);
            ptr2++;
        }
        return union;
    }
}

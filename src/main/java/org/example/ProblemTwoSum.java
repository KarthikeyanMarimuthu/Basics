package org.example;

import java.util.Arrays;
import java.util.HashMap;

public class ProblemTwoSum {

    public static void main(String[] args) {

        int [] arr = {11,3,7,9,14,2};
        int target = 17;

        System.out.print(Arrays.toString(twoSum(arr,target)));


    }


    static int [] twoSum(int [] arr, int target){


        HashMap <Integer,Integer> map = new HashMap<>();

        int[] res = new int[2];


        for(int i = 0; i< arr.length; i++){
           int temp = target - arr[i];
            if(map.containsKey(temp)){
                res[0] = i;
                res[1] = map.get(temp);

                return res;
            }

            map.put(arr[i], i);
        }

        return res;
    }
}

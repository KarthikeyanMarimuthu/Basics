package org.example;

import java.util.Arrays;

public class ProblemThreeSum {

    public static void main(String[] args) {


        int [] arr = {-1, -1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 6};
        int n = arr.length;
        int target = 6;

        threeSum(arr, target, n);

    }

    static void threeSum(int[] arr, int target, int n){


        // Sort the array , to make duplication removal easy
        Arrays.sort(arr);

        for(int i = 0; i< n; i++){

            // i==0 is bcoz of next condition, which leads to negative index for i == 0
            if( i == 0 || arr[i] != arr[i-1]){

                int j = i + 1 , k = n-1;
                int tmp_tar = target - arr[i];

                while(j < k ){

                    if(arr[j]+arr[k] == tmp_tar){
                        System.out.println(arr[i]+ " "+ arr[j]+ " "+ arr[k]);

                        while(j < k && arr[j] == arr[j+1]) j++;
                        while(j < k && arr[k] == arr[k-1]) k--;

                        // very important
                        j++;
                        k--;

                        // why we are reducing k , bcoz array is sorted and the sum is greater than target, we should remove largest number and we need to remove by reducing k only
                    } else if (arr[j]+arr[k] > tmp_tar) {
                        k--;
                    }
                    else{
                        j++;
                    }
                }



            }
        }

    }
}
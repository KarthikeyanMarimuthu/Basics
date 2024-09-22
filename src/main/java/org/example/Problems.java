package org.example;

import java.util.Arrays;

public class Problems {
    public static void main(String[] args) {


        int[] arr = {1,2,3,4,5,6,7,8};
        reverse(arr,0, arr.length-1);
        reverse(arr,0, 4);

        System.out.println(Arrays.toString(arr));

    }

    public static void reverse(int [] arr, int i , int j){

        while(i < j){

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }



    }

}


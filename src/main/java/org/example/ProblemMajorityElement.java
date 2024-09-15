package org.example;

public class ProblemMajorityElement {

    public static void main(String[] args) {


        int [] arr = { 2,4,5,2,8,3,99,22,1,2,2,2,5,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,};

        System.out.println(majaorityElement(arr));


    }

  /*   Using Moore's Algorithm
    1. Take first element as majority element
    2. Intialize the count as 1
    3. Iterate over each element in array starts from index 1
    4. Check if the arr[i] == to max
    5. If Yes increase the count value
    6. If No decrease the count value
    7. If the count value == 0 , make the current arr[i[ as max and re inintialize the count value as 1*/

    static int majaorityElement(int [] arr){


        int count = 1;

        int max = arr[0];
        for (int i = 1; i < arr.length; i++){

            if(arr[i] == max){
                count ++;
            }
            else{
                count --;
            }
            if(count == 0){
                max = arr[i];
                count = 1;
            }

        }
        int freq = 0;
        for (int i = 0; i < arr.length; i++){

            if(arr[i]== max){
                freq ++;
            }
        }
        if (freq >= arr.length/2){
            return max;
        }
        return -1;
    }
}

package org.example;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {

        int i = 4;
        String s = "hi";
        char c = 's';
        System.out.println(s+c+i);
        problem1();
        problem2();
        problem3();
        problem4();

        System.out.println(getAverage(1,3,4,5,7,8,9));

        System.out.println(gcd(18, 51));
        System.out.println(lcm(18, 51));
    }

    public static void problem1(){
        int [] arr1 = {1, 2, 3, 4, 5, 6, 4, 5, 8};

        System.out.println(arr1);

        int [] arr2 = {4, 5, 6, 7, 8, 9};

        int [] arr3 = new int[Math.min(arr1.length,arr2.length)];

        int count = 0;
        for(int i = 0; i < arr1.length; i++){

            for(int j = 0 ; j < arr2.length; j++){

                if(arr1[i]== arr2[j]){
                    boolean alreadyExists = false;
                    for(int k = 0; k <= count; k++){
                        if(arr1[i] == arr3[k]){
                            alreadyExists = true;
                            break;
                        }

                    }
                    if(!alreadyExists){
                        arr3[count] = arr1[i];
                        count++;
                    }

                }

            }
        }
        int[] arr4 = new int[count];
        for(int i =0 ; i< arr4.length;i++){
            arr4[i] =arr3[i];
        }
        System.out.println(Arrays.toString(arr4));



    }


    public static void problem2(){

        long res = (long)Math.pow(10,20);



        int [] arr1 = {1, 2, 3, 4, 5};
        int [] arr2 = new int[arr1.length];
        for(int i=0; i< arr1.length;i++){
            arr2[i] = arr1[i]*arr1[i];
        }
        System.out.println(Arrays.toString(arr2));


    }

    public static void problem3(){
        int[] arr1 = {1, 2, 3, 4, 5, 6, 9};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i =0 ; i< arr1.length; i++){

           max = Math.max(max, arr1[i]);
           min = Math.min(min, arr1[i]);
        }

        System.out.println("Max value is : " + max+" Min value is : "+min);
    }

    public static void problem4(){

        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        int len = arr1.length;
        int[] arr2 = new int[len];

        for(int i = 0 ; i < len; i++){
            arr2[len - i -1] = arr1[i];
        }

        System.out.println(Arrays.toString(arr2));
    }


    static float getAverage(float... varargs){

        float total =  0;

        for(float val : varargs){
            total += val;
        }

        float avg = total / varargs.length;

        return avg;

    }



    static int gcd(int a, int b){

        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
    public static int lcm(int a, int b) {
        int gcd = gcd(a,b);
      int lcm = (a * b) / gcd;
      return lcm;
    }

}

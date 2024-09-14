package org.example;

public class ProblemPrimeFoctors {


    public static void main(String[] args) {
        int num = 81000;
        System.out.println(primeFactors(num));
    }


    static int primeFactors(int num){

        //Prime Factors should range from 2 to 9;

        // It should be lesser digits, so we are iterating from reverse 9 to 2, so that Number is divisible by bigger number will give smaller digits


        //The Prime factors should be in ascending order, so we are going to add always the latest number in first.
        String ans = "";

        // Always greater than equal to when using reverse iteration >=
        for(int i = 9; i >= 2; i--){

            // It should be while, bcoz  we need to divide by the same number again and again
            while(num%i == 0){
                num = num / i;
                ans = i + ans;
            }
        }

        if(ans.isEmpty())
            return -1;
        else
            return Integer.parseInt(ans);
    }




}

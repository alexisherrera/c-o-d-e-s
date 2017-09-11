package arrays;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by alexisherrera on 8/16/17.
 */
public class P3 {

    //multiply two arbitrary-precision integers

    //given two arrays that represent integers multiply them and return them in an array form


    //initial thoughts: we have to mimick what multiplication truly is, which is the smaller number and
    //multiplying each value in it by the larger number then add them together.


    public static ArrayList<Integer> multiply(int[] num1, int[] num2) {

        //use this our result. we will do the addition as we go.
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < num1.length + num2.length; i++) {
            result.add(0);
        }

        System.out.println("length of arraylist is: " + result.size());

        //multiply from left to right because they are now reversed
        for (int i = num1.length - 1; i >= 0; i--) {

            //for each value in num1 we will multiply every value in num2. For each multiplication we will
            //add it to our result list, while adding simultaneously to save space
            int value1 = num1[i];


            for (int j = num2.length - 1; j >= 0; j--) {

                int value2 = num2[j];


                int resultVal = value1 * value2;

                //now we need to integrate this value into our result list
                //now we know that multiplying the numbers i and j, will yield a result of size i + j.

                //since both are single digits, then we know that the maximum size will be 2. With this, we need
                //to place the result in either indexOfResult or indexOfResult + 1 (if exceeds 1 digit place)

                //with this we can say that the result will go in the

                result.set(i + j + 1, resultVal + result.get(i + j + 1));

                //take care of any overflow by shifting it to the left by 1
                int overflow = result.get(i + j + 1) / 10;

                result.set(i + j, result.get(i + j) + overflow);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
                System.out.println(result);
            }
        }

        return result;

    }

    public static void reverse(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
         }
    }


    public static void main(String[] args) {
        int[] num1 = { 2, 3, 5, 9};
        int[] num2 ={ 4,0};

        ArrayList<Integer> r = multiply(num1, num2);

        System.out.println(r);

    }
}

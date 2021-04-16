package sort;

import java.util.Arrays;

/**
 * @Author: luweihong
 * @Date: 2021/4/16
 */
public class ArrayFactory {

    public static int[] forSort(){
        return new int[]{7,8,3,5,1,6,5,9,12,15,54,24,4};
    }

    public static void print(int[] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }
}

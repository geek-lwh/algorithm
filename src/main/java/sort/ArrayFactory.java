package sort;

import java.util.Arrays;

/**
 * @Author: luweihong
 * @Date: 2021/4/16
 */
public class ArrayFactory {

    public static int[] forSort(){
        return new int[]{7,8,3,5,1,6,5,9,12,15,54,24,4,77,33,11,23,45,66,1};
    }

    public static int[] newArray(int ... num){
        int[] arr = new int[num.length];
        for(int i = 0 ;i < num.length;i++){
            arr[i] = num[i];
        }

        return arr;
    }

    public static void print(int[] arr){
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}

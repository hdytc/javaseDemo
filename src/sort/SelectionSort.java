package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 选择右端最值放到当前位置，所以叫选择排序
 */
public class SelectionSort {
    public void selectSort(int[] a) {
        for(int i=0;i<a.length;i++) {
            int minIndex = i;
            //lookfor minIndex
            for(int j=i;j<a.length;j++) {
                if (a[minIndex] > a[j]) {
                    minIndex=j;
                }
            }
            //swap
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
    @Test
    public void test() {
        int[] a = {11,2,44,14,72,66,22,63,22,44,55};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}

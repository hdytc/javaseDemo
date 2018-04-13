package sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] a) {
        sort(a,0,a.length-1);
    }

    private void sort(int[] a, int first, int last) {
        if(first>=last) return;
        int index = partition(a,first,last); //定位1个数
        sort(a,first,index-1); //[last..index]排序
        sort(a,index+1,last);//[index+1,last]
    }

    private int partition(int[] a, int first, int last) {
        int num = a[first];
        int i =first;
        int j = last+1;
        while (true) {
            //使用do能在swap后，少做一次while循环
            do{
                i++;
            }while (a[i] < num && i<last);
            do{
                j--;
            }while (a[j] > num && j>first);
            if(i>=j) break;
            //swap
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[first] = a[j];
        a[j] =num;
        return j;
    }
    @Test
    public void test() {
        int[] a = {11,2,44,14,72,66,22,63,22,44,55};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}

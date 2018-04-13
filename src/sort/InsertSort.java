package sort;

import org.junit.Test;

import java.util.Arrays;

public class InsertSort {
    public void insertSort(int[] a) {
        for(int i=1;i<a.length;i++) {
            //小数向左冒泡直到找到自己位置或者到末尾
            for(int j=i;j>0 && a[j]<a[j-1];j--) {
                int temp = a[j-1];
                a[j-1] = a[j];
                a[j] = temp;
            }
        }
    }
    @Test
    public void test() {
        int[] a = {11,2,44,14,72,66,22,63,22,44,55};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}

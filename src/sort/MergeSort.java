package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;

public class MergeSort {
    private void sortByMid(int[] a,int first,int mid, int last,int[] temp) {
        //assert 0<=first<mid<last<=a.length
        //a[0...mid] a[mid+1...last]为有序
        int i = first,iLast =mid;
        int j=mid+1,jLast = last;
        int tempIndex=0;

        while (i <= iLast && j <= jLast) {
            if (a[i] > a[j]) {
                temp[tempIndex++] = a[j++];
            } else {
                temp[tempIndex++] = a[i++];
            }
        }
        while (i <= iLast) {
            temp[tempIndex++] = a[i++];
        }
        while (j <= jLast) {
            temp[tempIndex++] = a[j++];
        }
        System.out.println("sortByMid:"+Arrays.toString(temp));
        for(i = 0;i< tempIndex;i++) {
            a[first+i] = temp[i];
        }
    }

    private void mergesort(int[] a,int first,int last,int[] temp) {
        if (first < last) {
            int mid = (first+last)/2;
            mergesort(a,first,mid,temp);
            mergesort(a,mid+1,last,temp);
            sortByMid(a,first,mid,last,temp);
        }
    }

    public void mergeSort(int[] a) {
        int[] temp = new int[a.length];
        mergesort(a,0,a.length-1,temp);

    }
    @Test
    public void test() {
        int[] a = {11,2,44,14,72,66,22,63,22,44,55};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
